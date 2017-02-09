package almond.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class DashBoard {
	@Id
	@GeneratedValue
	private long invoiceSeq;

	private String accountId;

	private String lineItem;

	private LocalDateTime startTime;

	private LocalDateTime endTime;

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

	public long getInvoiceSeq() {
		return invoiceSeq;
	}

	public void setInvoiceSeq(long invoiceSeq) {
		this.invoiceSeq = invoiceSeq;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public String getLineItem() {
		return lineItem;
	}

	public void setLineItem(String lineItem) {
		this.lineItem = lineItem;
	}

	public LocalDateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalDateTime startTime) {
		this.startTime = startTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public String getMeasurement1() {
		return measurement1;
	}

	public void setMeasurement1(String measurement1) {
		this.measurement1 = measurement1;
	}

	public String getMeasurement1TotalConsumption() {
		return measurement1TotalConsumption;
	}

	public void setMeasurement1TotalConsumption(String measurement1TotalConsumption) {
		this.measurement1TotalConsumption = measurement1TotalConsumption;
	}

	public String getMeasurement1Units() {
		return measurement1Units;
	}

	public void setMeasurement1Units(String measurement1Units) {
		this.measurement1Units = measurement1Units;
	}

	public String getCredit1() {
		return credit1;
	}

	public void setCredit1(String credit1) {
		this.credit1 = credit1;
	}

	public String getCredit1Amount() {
		return credit1Amount;
	}

	public void setCredit1Amount(String credit1Amount) {
		this.credit1Amount = credit1Amount;
	}

	public String getCredit1Currency() {
		return credit1Currency;
	}

	public void setCredit1Currency(String credit1Currency) {
		this.credit1Currency = credit1Currency;
	}

	public String getCost() {
		return cost;
	}

	public void setCost(String cost) {
		this.cost = cost;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getProjectNumber() {
		return projectNumber;
	}

	public void setProjectNumber(String projectNumber) {
		this.projectNumber = projectNumber;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectLabels() {
		return projectLabels;
	}

	public void setProjectLabels(String projectLabels) {
		this.projectLabels = projectLabels;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getInvoiceFileName() {
		return invoiceFileName;
	}

	public void setInvoiceFileName(String invoiceFileName) {
		this.invoiceFileName = invoiceFileName;
	}

	public LocalDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}

}
