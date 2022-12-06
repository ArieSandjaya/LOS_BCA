package com.multifinance.model;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_EMPTY)
public class SentMailModel {
	private String EmailBody;
	private String Recipient;
	private String CC;
	private String subject;
	private String BCC;
	
	public SentMailModel() {
		super();
	}
	
	public String getEmailBody() {
		return EmailBody;
	}
	public void setEmailBody(String EmailBody) {
		this.EmailBody = EmailBody;
	}
	public String getRecipient() {
		return Recipient;
	}
	public void setRecipient(String Recipient) {
		this.Recipient = Recipient;
	}
	public String getCC() {
		return CC;
	}
	public void setCC(String CC) {
		this.CC = CC;
		
	}
	public String getBCC() {
		return BCC;
	}
	public void setBCC(String BCC) {
		this.BCC = BCC;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
}
