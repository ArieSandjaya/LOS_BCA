package com.multifinance.model;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.UUID;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;
import javax.persistence.Table;

@Entity
@Table(name = "cust" , schema = "multifinance")
public class CustModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
	private Long id;
	@Column(name = "cust_id")
	private UUID cust_id;
	@Column(name = "cust_type")
	private String cust_type;
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
 	@Column(name = "cis_id")
 	private Long cis_id;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UUID getCust_id() {
		return cust_id;
	}
	public void setCust_id(UUID cust_id) {
		this.cust_id = cust_id;
	}
	public String getCust_type() {
		return cust_type;
	}
	public void setCust_type(String cust_type) {
		this.cust_type = cust_type;
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
	public Long getCis_id() {
		return cis_id;
	}
	public void setCis_id(Long cis_id) {
		this.cis_id = cis_id;
	}
 	
	
}
