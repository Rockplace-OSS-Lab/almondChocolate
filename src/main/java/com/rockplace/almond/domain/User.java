package com.rockplace.almond.domain;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.apache.commons.lang3.RandomStringUtils;

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

	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<UserRole> userRoles;

	private int status;

	private LocalDateTime lastLogin;

	private LocalDateTime regDate = LocalDateTime.now();

	private String okKey;

	public User() {
		super();
	}

	public User(User user) {
		this.userSeq = user.userSeq;
		this.email = user.email;
		this.company = user.company;
		this.lastLogin = user.lastLogin;
		this.userRoles = user.userRoles;
		this.okKey = user.okKey;
		this.password = user.password;
		this.regDate = user.regDate;
		this.status = user.status;
	}

	public String createKey() {
		Calendar cal = Calendar.getInstance();
		this.okKey = String.valueOf(cal.getTimeInMillis() / 1000) + "" + RandomStringUtils.randomAlphanumeric(10);

		return okKey;
	}

	public void updateStatus() {
		this.status = 1;
	}

	public long getUserSeq() {
		return userSeq;
	}

	public void setUserSeq(long userSeq) {
		this.userSeq = userSeq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public List<UserRole> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getLastLogin() {
		return lastLogin;
	}

	public void setLastLogin(LocalDateTime lastLogin) {
		this.lastLogin = lastLogin;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public String getOkKey() {
		return okKey;
	}

	public void setOkKey(String okKey) {
		this.okKey = okKey;
	}

	@Override
	public String toString() {
		return "User [userSeq=" + userSeq + ", email=" + email + ", password=" + password + ", company=" + company
				+ ", status=" + status + ", lastLogin=" + lastLogin + ", regDate=" + regDate + ", okKey=" + okKey + "]";
	}

}