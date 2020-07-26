package com.app.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "COMMENTS")
public class Comment {

	@Id
	@Column(name = "id")
	@SequenceGenerator(name = "SEQ_COMMAND", sequenceName = "SEQ_COMMAND", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_COMMAND")
	private int id;

	@Column(name = "comment_details")
	private String commentDetails;

	@Column(name = "activity_id")
	private int activityId;

	@Column(name = "NICK_NAME")
	private String nickname;

	@Column(name = "comment_date")
	private Date commentDate;

	@Column(name = "status")
	private int status;

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

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}



	public Comment(String commentDetails, int activityId, String nickname, Date commentDate, int status) {
		this.commentDetails = commentDetails;
		this.activityId = activityId;
		this.nickname = nickname;
		this.commentDate = commentDate;
		this.status = status;
	}

	public Comment() {
	}

	@Override
	public String toString() {
		return "Comment [id=" + id + ", commentDetails=" + commentDetails + ", activityId=" + activityId + ", nickname="
				+ nickname + ", commentDate=" + commentDate + ", status=" + status + "]";
	}



}
