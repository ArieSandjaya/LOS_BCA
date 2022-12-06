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
@Table(name = "usr_profile" , schema = "oauth")
public class UsrProfileModel {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private String id;
	@Column(name = "fullname")
    private String fullname;
	@Column(name = "username")
    private String username;
	@Column(name = "account_non_locked")
    private boolean account_non_locked;
	@Column(name = "enabled")
    private boolean enabled;
	@Column(name = "login_attemp")
    private int login_attemp;
	@Column(name = "last_login")
    private Date last_login;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isAccount_non_blocked() {
		return account_non_locked;
	}
	public void setAccount_non_blocked(boolean account_non_blocked) {
		this.account_non_locked = account_non_blocked;
	}
	public boolean getEnabled() {
		return enabled;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	public int getLogin_attemp() {
		return login_attemp;
	}
	public void setLogin_attemp(int login_attemp) {
		this.login_attemp = login_attemp;
	}
	public Date getLast_login() {
		return last_login;
	}
	public void setLast_login(Date last_login) {
		this.last_login = last_login;
	}
	
}
