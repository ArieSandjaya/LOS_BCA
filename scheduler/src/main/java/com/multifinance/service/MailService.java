package com.multifinance.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.multifinance.model.SentMailModel;
import com.multifinance.model.response.ErrorModel;
import com.multifinance.util.CommonUtil;
import com.multifinance.util.ErrorResponseUtil;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class MailService {
	private static final Logger LOGGER = LoggerFactory.getLogger(MailService.class);
    @Value("${spring.mail.from}")
    private String mailFrom;

    @Autowired
    JavaMailSender javaMailSender;

    public ResponseEntity<String> sendMail(SentMailModel sentMailModel) throws JsonProcessingException, Exception {
    	ErrorModel errorResponseModel = new ErrorModel();
    	try {
    		SimpleMailMessage msg = new SimpleMailMessage();
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message);
            message.setSubject(sentMailModel.getSubject());
            message.setContent(sentMailModel.getEmailBody(),"text/html; charset=utf-8");
            message.setFrom(new InternetAddress(mailFrom));
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(sentMailModel.getRecipient()));
            javaMailSender.send(message);
            return new ResponseEntity<>("Message Sent", HttpStatus.OK);
    	}
    	catch(Exception e)
    	{
    		//e.printStackTrace();
    		 LOGGER.error("sendMail ERROR",e);
    		errorResponseModel.setErrorMessage("terjadi kesalahan");
			errorResponseModel.setStatus(HttpStatus.BAD_REQUEST.toString());
			return new ResponseEntity<>(CommonUtil.modelToString(errorResponseModel), ErrorResponseUtil.getHttpStat(errorResponseModel.getStatus()));
    	}
        
    }
}
