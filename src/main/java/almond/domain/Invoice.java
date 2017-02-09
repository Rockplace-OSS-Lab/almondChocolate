package almond.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Invoice {

	@Id
	@GeneratedValue
	private long invoiceSeq;
	
	private String accountId;
	
	private String lineItem;
	
	private String startTime;
	
	private String endTime;
	
	private String project;
	
	private String measurement1;
	
	private String measurement1TotalConsumption;
	
	private String measurement1Units;
	
	private String credit1;
	
	private String credit1Amount;
	
	private String credit1Currency;
	
	private String cost;
	
	private String currency;
	
	private String projectNumber;
	
	private String projectId;
	
	private String projectName;
	
	private String projectLabels;
	
	private String description;
	
	private String invoiceFileName;
	
	private LocalDateTime updateDate;

	public void setInvoiceSeq(long invoiceSeq) {
		this.invoiceSeq = invoiceSeq;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public void setLineItem(String lineItem) {
		this.lineItem = lineItem;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public void setMeasurement1(String measurement1) {
		this.measurement1 = measurement1;
	}

	public void setMeasurement1TotalConsumption(String measurement1TotalConsumption) {
		this.measurement1TotalConsumption = measurement1TotalConsumption;
	}

	public void setMeasurement1Units(String measurement1Units) {
		this.measurement1Units = measurement1Units;
	}

	public void setCredit1(String credit1) {
		this.credit1 = credit1;
	}

	public void setCredit1Amount(String credit1Amount) {
		this.credit1Amount = credit1Amount;
	}

	public void setCredit1Currency(String credit1Currency) {
		this.credit1Currency = credit1Currency;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public void setProjectLabels(String projectLabels) {
		this.projectLabels = projectLabels;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public void setInvoiceFileName(String invoiceFileName) {
		this.invoiceFileName = invoiceFileName;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
}
