package com.multifinance.service;

import com.multifinance.model.*;
import com.multifinance.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class ApplStatService {

    @Value("${repayment.appl.idle}")
    private long applIdle;

    @Value("${repayment.appl.max}")
    private long applMax;

    @Value("${repayment.appl.notif}")
    private long applNotif;

    @Value("${repayment.appl.status.from}")
    private String applStatusBetweenFrom;

    @Value("${repayment.appl.status.to}")
    private String applStatusBetweenTo;

    @Value("${repayment.appl.status.expired}")
    private String applStatusExpired;

    @Autowired
    private ApplStatRepository applStatRepository;

    @Autowired
    private NtfeRepository ntfeRepository;

    @Autowired
    private MailService mailService;

    @Autowired
    private ApplRepository applRepository;

    @Autowired
    private CustRepository custRepository;

    @Autowired
    private UsrProfileRepository usrRepository;

    public List<ApplStatModel> expiringIdleApplStat() {
        List<ApplStatModel> listApplStat = applStatRepository.findAllMaxCreatedAtByStatusBetween(applStatusBetweenFrom, applStatusBetweenTo);

        List<ApplStatModel> listIdleApplStat = new ArrayList<>();

        LocalDateTime lastDateTime;
        long lastMilliseconds;
        long currentMilliseconds;
        long milisecondsDiff;
        long daysDiff;

        //get list of data that already reach idle time
        for (ApplStatModel applStat : listApplStat) {
            if (applStat.getUpdateAt() != null) {
                lastDateTime = applStat.getUpdateAt();
            } else {
                lastDateTime = applStat.getCreatedAt();
            }

            currentMilliseconds = System.currentTimeMillis();
            lastMilliseconds = lastDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            milisecondsDiff = currentMilliseconds - lastMilliseconds;
            daysDiff = TimeUnit.MILLISECONDS.toDays(milisecondsDiff);

            if (daysDiff >= applIdle) {
                listIdleApplStat.add(applStat);
            }
        }

        //begin update status
        for (ApplStatModel applStat : listIdleApplStat) {
            applStat.setStatus(applStatusExpired);
            applStat.setUpdateAt(LocalDateTime.now());
            applStatRepository.save(applStat);
        }

        return listIdleApplStat;
    }

    public List<ApplStatModel> expiringMaxApplStat() {
        List<ApplStatModel> listApplStat = applStatRepository.findAllMinCreatedAtByStatusBetween(applStatusBetweenFrom, applStatusBetweenTo);

        List<ApplStatModel> listMaxApplStat = new ArrayList<>();

        LocalDateTime createdDateTime;
        long createdMilliseconds;
        long currentMilliseconds;
        long milisecondsDiff;
        long daysDiff;

        //get list of data that already reach maximum expiration time
        for (ApplStatModel applStat : listApplStat) {
            createdDateTime = applStat.getCreatedAt();

            currentMilliseconds = System.currentTimeMillis();
            createdMilliseconds = createdDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            milisecondsDiff = currentMilliseconds - createdMilliseconds;
            daysDiff = TimeUnit.MILLISECONDS.toDays(milisecondsDiff);

            if (daysDiff >= applMax) {
                listMaxApplStat.add(applStat);
            }
        }

        //begin update status
        for (ApplStatModel applStat : listMaxApplStat) {
            applStat.setStatus(applStatusExpired);
            applStat.setUpdateAt(LocalDateTime.now());
            applStatRepository.save(applStat);
        }

        return listMaxApplStat;
    }

    public List<ApplStatModel> notifApplStat() {
        List<ApplStatModel> listApplStat = applStatRepository.findAllMaxCreatedAtByStatusBetween(applStatusBetweenFrom, applStatusBetweenTo);

        List<ApplStatModel> listNotifApplStat = new ArrayList<>();

        LocalDateTime lastDateTime;
        long lastMilliseconds;
        long currentMilliseconds;
        long milisecondsDiff;
        long daysDiff;

        //get list of data that need to be notified
        for (ApplStatModel applStat : listApplStat) {
            if (applStat.getUpdateAt() != null) {
                lastDateTime = applStat.getUpdateAt();
            } else {
                lastDateTime = applStat.getCreatedAt();
            }

            currentMilliseconds = System.currentTimeMillis();
            lastMilliseconds = lastDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();

            milisecondsDiff = currentMilliseconds - lastMilliseconds;
            daysDiff = TimeUnit.MILLISECONDS.toDays(milisecondsDiff);

            if (daysDiff >= applNotif) {
                listNotifApplStat.add(applStat);
            }
        }

        //begin send notification email
        Optional<ApplModel> applMod;
        Optional<CustModel> custMod;
        Optional<UsrProfileModel> usrMod;
        NtfeModel ntfeModel = ntfeRepository.GetEmailText();
        for (ApplStatModel applStat : listNotifApplStat) {
            applMod = applRepository.findById(applStat.getApplId());
            custMod = custRepository.findById(applMod.get().getCust_id());
            usrMod = usrRepository.findById(custMod.get().getCust_id().toString());
            SentMailModel sentMailModel = new SentMailModel();
            sentMailModel.setRecipient(usrMod.get().getUsername());
            sentMailModel.setSubject(ntfeModel.getSubject());
            sentMailModel.setEmailBody("Please continue your application because it will be deleted after " + applIdle + " days of idle, or reach " + applMax + " of maximum time.");
            try {
                mailService.sendMail(sentMailModel);
            } catch(Exception e) {
                e.printStackTrace();
            }

        }

        return listNotifApplStat;
    }
}
