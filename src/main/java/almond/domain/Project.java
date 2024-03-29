package almond.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Project {

	@Id
	@GeneratedValue
	private long projectSeq;

	@ManyToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "fk_project_user"))
	private User user;

	private String projectId;

	private String adminEmail;

	private int status;

	private LocalDateTime regDate = LocalDateTime.now();

	private String okKey;

	public void setProjectSeq(long projectSeq) {
		this.projectSeq = projectSeq;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void setRegDate(LocalDateTime regDate) {
		this.regDate = regDate;
	}

	public void setOkKey(String okKey) {
		this.okKey = okKey;
	}

	public long getProjectSeq() {
		return projectSeq;
	}

	public User getUser() {
		return user;
	}

	public String getProjectId() {
		return projectId;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public int getStatus() {
		return status;
	}

	public LocalDateTime getRegDate() {
		return regDate;
	}

	public String getOkKey() {
		return okKey;
	}

}
