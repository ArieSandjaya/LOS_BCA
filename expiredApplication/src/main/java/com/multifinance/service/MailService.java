package com.multifinance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.model.SentMailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class MailService {

    @Value("${spring.mail.from}")
    private String mailFrom;

    @Autowired
    JavaMailSender javaMailSender;

    public ResponseEntity<String> sendMail(SentMailModel sentMailModel) throws JsonProcessingException {
        SimpleMailMessage msg = new SimpleMailMessage();

        msg.setFrom(mailFrom);
        msg.setTo(sentMailModel.getRecipient());
        msg.setText(sentMailModel.getEmailBody());
        msg.setSubject(sentMailModel.getSubject());
        javaMailSender.send(msg);
        return new ResponseEntity<>("Message Sent", HttpStatus.OK);
    }
}
