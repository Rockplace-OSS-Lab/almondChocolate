package com.rockplace.almond.domain;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class BillingAccount {

	@Id
	@GeneratedValue
	private long billingAccountSeq;
	
	@Column(nullable = false)
	private String billingAccount;
	
	@Column(nullable = false)
	private String adminEmail;
	
	private LocalDateTime regDate = LocalDateTime.now();

	public void setBillingAccountSeq(long billingAccountSeq) {
		this.billingAccountSeq = billingAccountSeq;
	}

	public void setBillingAccount(String billingAccount) {
		this.billingAccount = billingAccount;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}
	
}
