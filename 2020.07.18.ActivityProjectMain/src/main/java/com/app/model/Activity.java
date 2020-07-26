package com.app.model;

import java.sql.Date;

public class Activity {
	private int id;
	private String name;
	private String details;
	private Date date;
	private Integer status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Activity(int id, String name, String details, Date date, Integer status) {
		this.id = id;
		this.name = name;
		this.details = details;
		this.date = date;
		this.status = status;
	}

	public Activity() {
	}

	@Override
	public String toString() {
		return "Activity [id=" + id + ",\n name=" + name + ",\n details=" + details + ",\n date=" + date + ",\n status="
				+ status + "]\n";
	}

}
