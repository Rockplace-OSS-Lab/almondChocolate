package almond.domain;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ScheluderLog {
	
	@Id
	@GeneratedValue
	private long logSeq;
	
	private String scheduleId;
	
	private String message;
	
	// TODO EnumType을 oridinal과 string, 장,단점을 명확히 이해한 후 사용한다.
	@Enumerated(EnumType.ORDINAL)
	private ResultCode resultCode;
	
	private LocalDateTime updateDate = LocalDateTime.now();

	public void setLogSeq(long logSeq) {
		this.logSeq = logSeq;
	}

	public void setScheduleId(String scheduleId) {
		this.scheduleId = scheduleId;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public void setResultCode(ResultCode resultCode) {
		this.resultCode = resultCode;
	}

	public void setUpdateDate(LocalDateTime updateDate) {
		this.updateDate = updateDate;
	}
	
}
