package com.app.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table
public class Activity {

	@Id
	@Column(name = "ID")
	@SequenceGenerator(name = "SEQ_ACT", sequenceName = "SEQ_ACT", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ACT")
	private Integer id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DETAILS")
	private String details;

	@Column(name = "ACTIVITY_DATE")
	private Date date;
	
	@Column(name = "STATUS")
	private Integer status;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Activity(String name, String details, Date date, Integer status) {
		this.name = name;
		this.details = details;
		this.date = date;
		this.status = status;
	}

	public Activity() {
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ", name=" + name + ", details=" + details + ", date=" + date + ", status="
				+ status + "]";
	}
	
	

}
