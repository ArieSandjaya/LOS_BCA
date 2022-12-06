package com.multifinance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.model.*;
import com.multifinance.model.response.ErrorModel;
import com.multifinance.repository.*;
import com.multifinance.util.CommonUtil;
import com.multifinance.util.CustomLoggerUtil;
import com.multifinance.util.ErrorResponseUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.webservices.client.HttpWebServiceMessageSenderBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

@Service
public class ApplStatService {
private static final Logger LOGGER = LoggerFactory.getLogger(ApplStatService.class);
    @Value("${repayment.appl.idle}")
    private long applIdle;

    @Value("${repayment.appl.max}")
    private long applMax;

    @Value("${repayment.appl.notif}")
    private long applNotif;
    
    @Value("${repayment.appl.status.approved}")
    private long applStatusApproved;

    @Value("${repayment.appl.status.between.from}")
    private String applStatusBetweenFrom;

    @Value("${repayment.appl.status.between.to}")
    private String applStatusBetweenTo;
    
    @Value("${repayment.appl.status.submitbetween.from}")
    private String applStatusBetweenSubmitFrom;

    @Value("${repayment.appl.status.submitbetween.to}")
    private String applStatusBetweenSumbitTo;
    
    @Value("${repayment.appl.status.expired}")
    private String applStatusExpired;

    @Value("${repayment.appl.status.cancel}")
    private String applStatusCancel;

    @Value("${repayment.appl.mail.url.akan-expired}")
    private String applMailUrlAkanExpired;

    @Value("${repayment.appl.mail.url.sudah-expired}")
    private String applMailUrlSudahExpired;

    @Value("${repayment.appl.mail.url.akan-expired}")
    private String applMailUrlPinjamanDibatalkan;

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
    
    private String LogMsg;
//    public ResponseEntity<String> expiringIdleApplStat() throws JsonProcessingException {
//    	ErrorModel errorResponseModel = new ErrorModel();
//    	try 
//			{
//				List<ApplStatModel> listApplStat = applStatRepository.findAllMaxCreatedAtByStatusBetween(Integer.valueOf(applStatusBetweenFrom), Integer.valueOf(applStatusBetweenTo), applIdle);
//				List<ApplStatModel> listIdleApplStat = new ArrayList<>();
//
//    	        LocalDateTime lastDateTime;
//    	        long lastMilliseconds;
//    	        long currentMilliseconds;
//    	        long milisecondsDiff;
//    	        long daysDiff;
//    	        
//    	        Optional<ApplModel> applMod;
//    	        Optional<CustModel> custMod;
//    	        Optional<UsrProfileModel> usrMod;
//    	        @SuppressWarnings("unused")
//				int errMail = 0;
//    	        NtfeModel ntfeModel = ntfeRepository.GetExpiredPinjaman();
//    	        //get list of data that already reach idle time
//    	        for (ApplStatModel applStat : listApplStat) 
//				{
////    	            if (applStat.getUpdateAt() != null) {
////    	                lastDateTime = applStat.getUpdateAt();
////    	            } 
////					else 
////					{
////    	                lastDateTime = applStat.getCreatedAt();
////    	            }
//
//    	            currentMilliseconds = System.currentTimeMillis();
////    	            lastMilliseconds = lastDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//
////    	            milisecondsDiff = currentMilliseconds - lastMilliseconds;
////    	            daysDiff = TimeUnit.MILLISECONDS.toDays(milisecondsDiff);
//
////    	            if (daysDiff >= applIdle) 
////					{
////    	                listIdleApplStat.add(applStat);
////    	            }
//    	        }
//
//    	        //begin update status
//    	        for (ApplStatModel applStat : listIdleApplStat) 
//				{
//    	        	try
//    				{
////	    	            applStat.setStatus(applStatusExpired);
////	    	            applStat.setLastStatus(applStatusExpired);
////	    	            applStat.setUpdateAt(LocalDateTime.now());
//	    	            applStatRepository.save(applStat);
//	    	            applMod = applRepository.findById(applStat.getApplId());
//	    	            custMod = custRepository.findById(applMod.get().getCust_id());
//	    	            usrMod = usrRepository.findById(custMod.get().getCust_id().toString());
//	    	            SentMailModel sentMailModel = new SentMailModel();
//	    	            sentMailModel.setRecipient(usrMod.get().getUsername());
//	    	            sentMailModel.setSubject(ntfeModel.getSubject());
//	    	            String emailBody = ntfeModel.getBody();
//	    	            emailBody = CommonUtil.replaceString(emailBody,"${fullName}", usrMod.get().getFullname());
//	    	            emailBody = CommonUtil.replaceString(emailBody,"${submiteDate}", CommonUtil.DateFormatter(applMod.get().getCreatedAt()));
//	                    emailBody = CommonUtil.replaceString(emailBody,"${link}", applMailUrlSudahExpired);
//	                    emailBody = CommonUtil.replaceString(emailBody,"${email}", usrMod.get().getUsername());
//	    	            sentMailModel.setEmailBody(emailBody);
//    				}
//    				catch(Exception exp)
//    				{
//    					++errMail;
//    					LOGGER.error("expiringIdleApplStat ERROR",exp);
//    				}
//    	        }
//    	        
//    	        if (errMail == 0)
//    			{
//    				return new ResponseEntity<>("OK", HttpStatus.OK);
//    			}
//    			else
//    			{
//    				return new ResponseEntity<>("OK With Exception", HttpStatus.OK);
//    			}
//    		
//			} 
//			catch (Exception e)
//			{
//				LOGGER.error("expiringIdleApplStat ERROR",e);
//				errorResponseModel.setErrorMessage("terjadi kesalahan");
//				errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
//				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
//			}
//    }
//    
//    public  ResponseEntity<String>  expiringMaxApplStat() throws JsonProcessingException 
//	{
//    	ErrorModel errorResponseModel = new ErrorModel();
//    	try 
//			{
//					List<ApplStatModel> listApplStat = applStatRepository.findAllMinCreatedAtByStatusBetween(Integer.valueOf(applStatusBetweenFrom), Integer.valueOf(applStatusBetweenTo));
//					List<ApplStatModel> listMaxApplStat = new ArrayList<>();
//
//					LocalDateTime createdDateTime;
//					long createdMilliseconds;
//					long currentMilliseconds;
//					long milisecondsDiff;
//					long daysDiff;
//
//					//get list of data that already reach maximum expiration time
//					for (ApplStatModel applStat : listApplStat) 
//					{
//						createdDateTime = applStat.getCreatedAt();
//						currentMilliseconds = System.currentTimeMillis();
//						createdMilliseconds = createdDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//						milisecondsDiff = currentMilliseconds - createdMilliseconds;
//						daysDiff = TimeUnit.MILLISECONDS.toDays(milisecondsDiff);
//
//					if (daysDiff >= applMax) 
//					{
//						listMaxApplStat.add(applStat);
//					}
//				}
//				Optional<ApplModel> applMod;
//				Optional<CustModel> custMod;
//				Optional<UsrProfileModel> usrMod;
//				int errMail = 0;
//				NtfeModel ntfeModel = ntfeRepository.GetExpiredPinjaman();
//				//begin update status
//				for (ApplStatModel applStat : listMaxApplStat) 
//				{
//					try
//						{
////							applStat.setStatus(applStatusExpired);
////							applStat.setLastStatus(applStatusExpired);
////							applStat.setUpdateAt(LocalDateTime.now());
//							applStatRepository.save(applStat);
//							applMod = applRepository.findById(applStat.getApplId());
//							custMod = custRepository.findById(applMod.get().getCust_id());
//							usrMod = usrRepository.findById(custMod.get().getCust_id().toString());
//							SentMailModel sentMailModel = new SentMailModel();
//							sentMailModel.setRecipient(usrMod.get().getUsername());
//							sentMailModel.setSubject(ntfeModel.getSubject());
//							String emailBody = ntfeModel.getBody();
//							emailBody = CommonUtil.replaceString(emailBody,"${fullName}", usrMod.get().getFullname());
//							emailBody = CommonUtil.replaceString(emailBody,"${submiteDate}", CommonUtil.DateFormatter(applMod.get().getCreatedAt()));
//							emailBody = CommonUtil.replaceString(emailBody,"${link}", applMailUrlSudahExpired);
//							emailBody = CommonUtil.replaceString(emailBody,"${email}", usrMod.get().getUsername());
//							sentMailModel.setEmailBody(emailBody);
//							mailService.sendMail(sentMailModel);
//						}
//					catch(Exception exp)
//						{
//							++errMail;
//							LOGGER.error("expiringMaxApplStatAfterSubmit ERROR",exp);
//						}
//				}
//				if (errMail == 0)
//					{
//						return new ResponseEntity<>("OK", HttpStatus.OK);
//					}
//						else
//					{
//						return new ResponseEntity<>("OK With Exception", HttpStatus.OK);
//					}
//			}
//		catch (Exception e)
//			{
//				LOGGER.error("expiringMaxApplStat ERROR",e);
//				errorResponseModel.setErrorMessage("terjadi kesalahan");
//				errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
//				return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
//			}
//    }
//    public  ResponseEntity<String>  expiringMaxApplStatAfterSubmit() throws JsonProcessingException 
//	{
//    	ErrorModel errorResponseModel = new ErrorModel();
//    	try 
//			{
//			List<ApplStatModel> listApplStat = applStatRepository.findAllMinCreatedAtByStatusBetween(Integer.valueOf(applStatusBetweenSubmitFrom), Integer.valueOf(applStatusBetweenSumbitTo));
//			List<ApplStatModel> listMaxApplStat = new ArrayList<>();
//			LocalDateTime createdDateTime;
//			long createdMilliseconds;
//			long currentMilliseconds;
//			long milisecondsDiff;
//			long daysDiff;
//
//        //get list of data that already reach maximum expiration time
//			for (ApplStatModel applStat : listApplStat) 
//			{
//				createdDateTime = applStat.getCreatedAt();
//				currentMilliseconds = System.currentTimeMillis();
//				createdMilliseconds = createdDateTime.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
//				milisecondsDiff = currentMilliseconds - createdMilliseconds;
//				daysDiff = TimeUnit.MILLISECONDS.toDays(milisecondsDiff);
//				if (daysDiff >= applIdle) 
//				{
//					listMaxApplStat.add(applStat);
//				}
//			}
//        Optional<ApplModel> applMod;
//        Optional<CustModel> custMod;
//        Optional<UsrProfileModel> usrMod;
//        @SuppressWarnings("unused")
//		int errMail = 0;
//        NtfeModel ntfeModel = ntfeRepository.GetBatalPinjamEmail();
//        //begin update status
//        for (ApplStatModel applStat : listMaxApplStat) 
//		{
//			try
//				{
////					applStat.setStatus(applStatusCancel);
////					applStat.setLastStatus(applStatusCancel);
////					applStat.setUpdateAt(LocalDateTime.now());
//					applStatRepository.save(applStat);
//					applMod = applRepository.findById(applStat.getApplId());
//					custMod = custRepository.findById(applMod.get().getCust_id());
//					usrMod = usrRepository.findById(custMod.get().getCust_id().toString());
//					SentMailModel sentMailModel = new SentMailModel();
//					sentMailModel.setRecipient(usrMod.get().getUsername());
//					sentMailModel.setSubject(ntfeModel.getSubject());
//					String emailBody = ntfeModel.getBody();
//					emailBody = CommonUtil.replaceString(emailBody,"${fullName}", usrMod.get().getFullname());
//					emailBody = CommonUtil.replaceString(emailBody,"${submiteDate}", CommonUtil.DateFormatter(applMod.get().getCreatedAt()));
//					emailBody = CommonUtil.replaceString(emailBody,"${link}", applMailUrlPinjamanDibatalkan);
//					emailBody = CommonUtil.replaceString(emailBody,"${email}", usrMod.get().getUsername());
//					sentMailModel.setEmailBody(emailBody);
//					mailService.sendMail(sentMailModel);
//				}
//			catch(Exception exp)
//				{
//					++errMail;
//					LOGGER.error("expiringMaxApplStatAfterSubmit ERROR",exp);
//				}
//        }
//        if (errMail == 0)
//			{
//				return new ResponseEntity<>("OK", HttpStatus.OK);
//			}
//			else
//			{
//				return new ResponseEntity<>("OK With Exception", HttpStatus.OK);
//			}
//    	}
//    	catch (Exception e)
//    	{
//    		//e.printStackTrace();
//    		LOGGER.error("expiringMaxApplStatAfterSubmit ERROR",e);
//			errorResponseModel.setErrorMessage("terjadi kesalahan");
//			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
//			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
//    	}
//       
//    }
    @SuppressWarnings("unused")
	public  ResponseEntity<String>  notifApplStat()  throws JsonProcessingException {
    	ErrorModel errorResponseModel = new ErrorModel();
    	int errMail = 0;
    	try {
    			List<ApplStatModel> listApplStat = applStatRepository.findAllDraftNotif(Integer.valueOf(applStatusBetweenFrom), Integer.valueOf(applStatusBetweenTo), applNotif);
    		
    			NtfeModel ntfeModel = ntfeRepository.GetEmailText();
    			String emailBody = ntfeModel.getBody();
    			String subject = ntfeModel.getSubject();
    			String emailLink = applMailUrlAkanExpired;
    			for (ApplStatModel applStat : listApplStat) {
    				ResponseEntity<String> eMail = SendMail(applStat.getusername(), subject, applStat.getFullName(), applStat.getCreatedAt(), emailBody, emailLink);
    				if(eMail.getStatusCode() == HttpStatus.OK)
    				{
    					LogMsg = LogMsg +  "Notification for " + applStat.getApplId() + "Sending Succesfully " + "at " + LocalDateTime.now() + "\r\n";
//    					CustomLoggerUtil.logInfo("Notification for " + applStat.getApplId() + "Sending Succesfully " + "at " + LocalDateTime.now());
    				}
    				else
    				{
    					LogMsg = LogMsg + "Error when sending Email";
    					++errMail;
    				}
    			}
    			if (errMail == 0)
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK", HttpStatus.OK);
    				}
    				else
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK With Exception", HttpStatus.OK);
    				}
    	}
    	catch (Exception e)
    	{
    		LogMsg = LogMsg + "error when fetch data \r\n";
    		//e.printStackTrace();
    		CustomLoggerUtil.logInfo(LogMsg);
			errorResponseModel.setErrorMessage(e.getMessage());
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
    	}
    }
    
    @SuppressWarnings("unused")
	public  ResponseEntity<String>  expiringIdleApplStat()  throws JsonProcessingException {
    	ErrorModel errorResponseModel = new ErrorModel();
    	int errMail = 0;
    	try {
    			List<ApplStatModel> listApplStat = applStatRepository.findAllDraftExpired(Integer.valueOf(applStatusBetweenFrom), Integer.valueOf(applStatusBetweenTo), applIdle);
    		
    			NtfeModel ntfeModel = ntfeRepository.GetExpiredPinjaman();
    			String emailBody = ntfeModel.getBody();
    			String subject = ntfeModel.getSubject();
    			String emailLink = applMailUrlSudahExpired;
    			for (ApplStatModel applStat : listApplStat) {
    				ResponseEntity<String> eMail = SendMail(applStat.getusername(), subject, applStat.getFullName(), applStat.getCreatedAt(), emailBody, emailLink);
    				if(eMail.getStatusCode() == HttpStatus.OK)
    				{
    					applStatRepository.updateApplStatus(applStatusExpired, applStat.getId(), LocalDateTime.now());
    					applStatRepository.updateApplLastStatus(applStatusExpired, applStat.getApplId(), LocalDateTime.now());
    					LogMsg = LogMsg +  "Notification for " + applStat.getApplId() + "Sending Succesfully " + "at " + LocalDateTime.now() + "\r\n";
    				}
    				else
    				{
    					LogMsg = LogMsg + "Error when sending Email";
    					++errMail;
    				}
    			}
    			if (errMail == 0)
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK", HttpStatus.OK);
    				}
    				else
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK With Exception", HttpStatus.OK);
    				}
    	}
    	catch (Exception e)
    	{
    		LogMsg = LogMsg + "error when fetch data \r\n";
    		CustomLoggerUtil.logInfo(LogMsg);
    		//e.printStackTrace();
//    		CustomLoggerUtil.logError(e);
			errorResponseModel.setErrorMessage(e.getMessage());
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
    	}
    }
    
    @SuppressWarnings("unused")
	public  ResponseEntity<String>  expiringMaxApplStat()  throws JsonProcessingException {
    	ErrorModel errorResponseModel = new ErrorModel();
    	int errMail = 0;
    	try {
    			List<ApplStatModel> listApplStat = applStatRepository.findAllDraftLifeTimeExpired(Integer.valueOf(applStatusBetweenFrom), Integer.valueOf(applStatusBetweenTo), applMax);
    		
    			NtfeModel ntfeModel = ntfeRepository.GetExpiredPinjaman();
    			String emailBody = ntfeModel.getBody();
    			String subject = ntfeModel.getSubject();
    			String emailLink = applMailUrlSudahExpired;
    			for (ApplStatModel applStat : listApplStat) {
    				ResponseEntity<String> eMail = SendMail(applStat.getusername(), subject, applStat.getFullName(), applStat.getCreatedAt(), emailBody, emailLink);
    				if(eMail.getStatusCode() == HttpStatus.OK)
    				{
    					applStatRepository.updateApplStatus(applStatusExpired, applStat.getId(), LocalDateTime.now());
    					applStatRepository.updateApplLastStatus(applStatusExpired, applStat.getApplId(), LocalDateTime.now());
    					LogMsg = LogMsg +  "Notification for " + applStat.getApplId() + "Sending Succesfully " + "at " + LocalDateTime.now() + "\r\n";
    				}
    				else
    				{
    					LogMsg = LogMsg + "Error when sending Email";
    					++errMail;
    				}
    			}
    			if (errMail == 0)
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK", HttpStatus.OK);
    				}
    				else
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK With Exception", HttpStatus.OK);
    				}
    	}
    	catch (Exception e)
    	{
    		LogMsg = LogMsg + "error when fetch data \r\n";
    		//e.printStackTrace();
    		CustomLoggerUtil.logInfo(LogMsg);
			errorResponseModel.setErrorMessage(e.getMessage());
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
    	}
    }
    
    
    @SuppressWarnings("unused")
	public  ResponseEntity<String>  expiringMaxApplStatAfterSubmit()  throws JsonProcessingException {
    	ErrorModel errorResponseModel = new ErrorModel();
    	int errMail = 0;
    	try {
    			List<ApplStatModel> listApplStat = applStatRepository.findAllSubmitExpired(applIdle, applStatusApproved);
    		
    			NtfeModel ntfeModel = ntfeRepository.GetBatalPinjamEmail();
    			String emailBody = ntfeModel.getBody();
    			String subject = ntfeModel.getSubject();
    			String emailLink = applMailUrlPinjamanDibatalkan;
    			for (ApplStatModel applStat : listApplStat) {
    				ResponseEntity<String> eMail = SendMail(applStat.getusername(), subject, applStat.getFullName(), applStat.getCreatedAt(), emailBody, emailLink);
    				if(eMail.getStatusCode() == HttpStatus.OK)
    				{
    					applStatRepository.updateApplStatus(applStatusCancel, applStat.getId(), LocalDateTime.now());
    					applStatRepository.updateApplLastStatus(applStatusCancel, applStat.getApplId(), LocalDateTime.now());
    					LogMsg = LogMsg +  "Notification for " + applStat.getApplId() + "Sending Succesfully " + "at " + LocalDateTime.now() + "\r\n";
    				}
    				else
    				{
    					LogMsg = LogMsg + "Error when sending Email";
    					++errMail;
    				}
    			}
    			if (errMail == 0)
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK", HttpStatus.OK);
    					
    				}
    				else
    				{
    					CustomLoggerUtil.logInfo(LogMsg);
    					return new ResponseEntity<>("OK With Exception", HttpStatus.OK);
    				}
    	}
    	catch (Exception e)
    	{
    		LogMsg = LogMsg + "error when fetch data \r\n";
    		//e.printStackTrace();
    		CustomLoggerUtil.logInfo(LogMsg);
			errorResponseModel.setErrorMessage(e.getMessage());
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
    	}
    }
    
    
    private ResponseEntity<String> SendMail(String Recipient, String Subject, String FullName, LocalDateTime SubmitedDate, String emailBody, String emailLink) throws Exception 
    {
    	SentMailModel sentMailModel = new SentMailModel();
		sentMailModel.setRecipient(Recipient);
		sentMailModel.setSubject(Subject);
				
        emailBody = CommonUtil.replaceString(emailBody,"${fullName}", FullName);
        emailBody = CommonUtil.replaceString(emailBody,"${submiteDate}", CommonUtil.DateFormatter(SubmitedDate));
        emailBody = CommonUtil.replaceString(emailBody,"${link}", emailLink);
        emailBody = CommonUtil.replaceString(emailBody,"${email}", Recipient);
        sentMailModel.setEmailBody(emailBody);
        return mailService.sendMail(sentMailModel);
    }
}
