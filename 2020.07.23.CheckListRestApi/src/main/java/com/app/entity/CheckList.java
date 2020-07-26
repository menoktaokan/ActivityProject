package com.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CHECK_LIST")
public class CheckList {
	@Id
	@SequenceGenerator(name = "SEQ_CHECKLIST", sequenceName = "SEQ_CHECKLIST", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CHECKLIST")
	@Column(name = "ID")
	private Integer id;
	
	@Column(name = "ACTIVITY_ID")
	private Integer activityId;
	
	@Column(name = "USER_NAME")
	private String username;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getActivityId() {
		return activityId;
	}

	public void setActivityId(Integer activityId) {
		this.activityId = activityId;
	}

	public CheckList(Integer activityId, String username) {
		this.activityId = activityId;
		this.username = username;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public CheckList() {
	}

}
