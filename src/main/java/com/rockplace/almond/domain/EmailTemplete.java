package com.rockplace.almond.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Entity
public class EmailTemplete {

	@Id
	@GeneratedValue
	private long templeteSeq;

	private String type;

	private String fromUser;

	private String toUser;

	private String ccUser;

	private String title;

	@Lob
	private String contents;

	public String contents(User user) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.currentRequestAttributes();
		String contextPath = attr.getRequest().getRequestURL().toString() + "_ok";
		this.contents = "사용자 승인 테스트" + user.getEmail() + "<br><br>" + "<a href='" + contextPath + "?email="
				+ user.getEmail() + "&okKey=" + user.getOkKey() + "'>승인</a>";
		return contents;
	}

	public void setTempleteSeq(long templeteSeq) {
		this.templeteSeq = templeteSeq;
	}

	public void setType(String type) {
		this.type = type;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public void setCcUser(String ccUser) {
		this.ccUser = ccUser;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

}
