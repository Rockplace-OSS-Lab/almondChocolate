package almond.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Bucket {

	@Id
	@GeneratedValue
	private long bucketSeq;
	
	private String projectId;

	private String bucketName;
	
	private String jsonFileName;
	
	private boolean deleted;

	public void setBucketSeq(long bucketSeq) {
		this.bucketSeq = bucketSeq;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public void setJsonFileName(String jsonFileName) {
		this.jsonFileName = jsonFileName;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}
	
}
