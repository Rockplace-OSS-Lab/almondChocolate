package com.rockplace.almond.domain;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class UserRole {
	
	@Id
	@GeneratedValue
	private long userRoleId;
	
	@ManyToOne
	@JoinColumn(foreignKey=@ForeignKey(name="fk_userRole_to_user"))
	private User user;
	
	private String role;
	
	public UserRole() {
		super();
	}

	public long getUserRoleId() {
		return userRoleId;
	}

	public void setUserRoleId(long userRoleId) {
		this.userRoleId = userRoleId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public String toString() {
		return role;
	}

}