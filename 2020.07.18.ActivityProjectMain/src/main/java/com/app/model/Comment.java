package com.app.model;

import java.util.Date;

public class Comment {

	private int id;
	private String commentDetails;
	private int activityId;
	private String nickname;
	private Date commentDate;
	private int status;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCommentDetails() {
		return commentDetails;
	}

	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}

	public int getActivityId() {
		return activityId;
	}

	public void setActivityId(int activityId) {
		this.activityId = activityId;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Date getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(Date commentDate) {
		this.commentDate = commentDate;
	}

	public Comment() {
	}

	public Comment(String commentDetails, int activityId, String nickname, Date commentDate, int status) {
		this.commentDetails = commentDetails;
		this.activityId = activityId;
		this.nickname = nickname;
		this.commentDate = commentDate;
		this.status = status;
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentDetails=" + commentDetails + ", activityId=" + activityId + ", nickname="
				+ nickname + ", commentDate=" + commentDate + ", status=" + status + "]";
	}

}
