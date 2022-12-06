package com.multifinance.model;
import javax.persistence.Column;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Table;

@Entity
@Table(name = "appl" , schema = "multifinance")
public class ApplModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
	@Column(name = "appl_id")
	private UUID appl_id;
	@Column(name = "appl_date")
	private Date appl_date;
	@Column(name = "cust_id")
	private Long cust_id;
	@Column(name = "empl_id")
	private Long empl_id;
	@Column(name = "customer_type")
	private Long customer_type;
	@Column(name = "platform")
	private String platform;
	@Column(name = "top")
	private Long top;
	@Column(name = "period_installment")
	private String period_installment;
	@Column(name = "installment_type")
	private Long installment_type;
	@Column(name = "collection_payment")
	private Long collection_payment;
	@Column(name = "comp_id")
	private Long comp_id;
	@Column(name = "created_at")
 	private LocalDateTime createdAt;
 	@Column(name = "created_by")
 	private Long createdBy; 
 	@Column(name = "update_at")
 	private LocalDateTime updateAt;
 	@Column(name = "update_by")
 	private Long updateBy;
 	@Column(name = "plafond")
 	private Long plafond; 
 	@Column(name = "installment_payment")
 	private Long installment_payment;
 	@Column(name = "no_ticket")
 	private String no_ticket; 
 	@Column(name = "loan_purpose")
 	private String loan_purpose; 
 	@Column(name = "channel")
 	private String channel; 
 	@Column(name = "submission_code")
 	private String submission_code;
	public UUID getAppl_id() {
		return appl_id;
	}
	public void setAppl_id(UUID appl_id) {
		this.appl_id = appl_id;
	}
	public Date getAppl_date() {
		return appl_date;
	}
	public void setAppl_date(Date appl_date) {
		this.appl_date = appl_date;
	}
	public Long getCust_id() {
		return cust_id;
	}
	public void setCust_id(Long cust_id) {
		this.cust_id = cust_id;
	}
	public Long getEmpl_id() {
		return empl_id;
	}
	public void setEmpl_id(Long empl_id) {
		this.empl_id = empl_id;
	}
	public Long getCustomer_type() {
		return customer_type;
	}
	public void setCustomer_type(Long customer_type) {
		this.customer_type = customer_type;
	}
	public String getPlatform() {
		return platform;
	}
	public void setPlatform(String platform) {
		this.platform = platform;
	}
	public Long getTop() {
		return top;
	}
	public void setTop(Long top) {
		this.top = top;
	}
	public String getPeriod_installment() {
		return period_installment;
	}
	public void setPeriod_installment(String period_installment) {
		this.period_installment = period_installment;
	}
	public Long getInstallment_type() {
		return installment_type;
	}
	public void setInstallment_type(Long installment_type) {
		this.installment_type = installment_type;
	}
	public Long getCollection_payment() {
		return collection_payment;
	}
	public void setCollection_payment(Long collection_payment) {
		this.collection_payment = collection_payment;
	}
	public Long getComp_id() {
		return comp_id;
	}
	public void setComp_id(Long comp_id) {
		this.comp_id = comp_id;
	}
	public LocalDateTime getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}
	public Long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}
	public LocalDateTime getUpdateAt() {
		return updateAt;
	}
	public void setUpdateAt(LocalDateTime updateAt) {
		this.updateAt = updateAt;
	}
	public Long getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(Long updateBy) {
		this.updateBy = updateBy;
	}
	public Long getPlafond() {
		return plafond;
	}
	public void setPlafond(Long plafond) {
		this.plafond = plafond;
	}
	public Long getInstallment_payment() {
		return installment_payment;
	}
	public void setInstallment_payment(Long installment_payment) {
		this.installment_payment = installment_payment;
	}
	public String getNo_ticket() {
		return no_ticket;
	}
	public void setNo_ticket(String no_ticket) {
		this.no_ticket = no_ticket;
	}
	public String getLoan_purpose() {
		return loan_purpose;
	}
	public void setLoan_purpose(String loan_purpose) {
		this.loan_purpose = loan_purpose;
	}
	public String getChannel() {
		return channel;
	}
	public void setChannel(String channel) {
		this.channel = channel;
	}
	public String getSubmission_code() {
		return submission_code;
	}
	public void setSubmission_code(String submission_code) {
		this.submission_code = submission_code;
	} 
	
}
