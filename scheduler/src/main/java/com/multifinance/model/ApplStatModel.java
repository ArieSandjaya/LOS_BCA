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
@Table(name = "appl_stat" , schema = "multifinance")

public class ApplStatModel {
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Long id;
	 	//@Column(name = "appl_stat_id")
	    //private UUID applStatId;
	 	@Column(name = "appl_id")
	    private Long applId;
	 	
	 	@Column(name = "username")
	 	private String username;
	 	
	 	@Column(name = "fullname")
	 	private String fullname;
	 	
//	 	@Column(name =  "comp_id")
//	 	private Long compId;
	 	@Column(name = "created_at")
	 	private LocalDateTime createdAt;
//	 	@Column(name = "created_by")
//	 	private Long createdBy; 
//	 	@Column(name = "update_at")
//	 	private LocalDateTime updateAt;
//	 	@Column(name = "update_by")
//	 	private Long updateBy; 
		@Column(name = "last_status")
	 	private String lastStatus;
		
		@Column(name = "ddiff")
	 	private Integer ddiff;
		
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
//		public UUID getApplStatId() {
//			return applStatId;
//		}
//		public void setApplStatId(UUID applStatId) {
//			this.applStatId = applStatId;
//		}
		public Long getApplId() {
			return applId;
		}
		public void setApplId(Long applId) {
			this.applId = applId;
		}
//		public String getStatus() {
//			return status;
//		}
//		public void setStatus(String status) {
//			this.status = status;
//		}
//		public Long getCompId() {
//			return compId;
//		}
//		public void setCompId(Long compId) {
//			this.compId = compId;
//		}
		public LocalDateTime getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(LocalDateTime createdAt) {
			this.createdAt = createdAt;
		}
//		public Long getCreatedBy() {
//			return createdBy;
//		}
//		public void setCreatedBy(Long createdBy) {
//			this.createdBy = createdBy;
//		}
//		public LocalDateTime getUpdateAt() {
//			return updateAt;
//		}
//		public void setUpdateAt(LocalDateTime updateAt) {
//			this.updateAt = updateAt;
//		}
		
		public String getusername() {
			return username;
		}
		public void setusername(String username) {
			this.username = username;
		}
		
		public String getFullName() {
			return fullname;
		}
		public void setFullName(String fullname) {
			this.fullname = fullname;
		}
		
		public String getLastStatus() {
			return lastStatus;
		}
		public void setLastStatus(String lastStatus) {
			this.lastStatus = lastStatus;
		} 
		public Integer getddiff() {
			return ddiff;
		}
		public void setddiff(Integer ddiff) {
			this.ddiff = ddiff;
		}
		
}
