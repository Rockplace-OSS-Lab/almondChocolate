package com.rockplace.almond.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class User {

	@Id
	@GeneratedValue
	private long userSeq;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String password;
	
	private String company;
	
	private int level;
	
	private int status;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime lastLogin;
	
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime regDate = LocalDateTime.now();
	
	private String okKey;

	public void setUserSeq(long userSeq) {
		this.userSeq = userSeq;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public void setOkKey(String okKey) {
		this.okKey = okKey;
	}
	
}
