package com.app.service;

import java.util.List;

import com.app.entity.Comment;

public interface CommentService {
	
	public List<Comment> getActivityList(int id);
	
	public void addComment(Comment command);
	
	public int deleteComment(int id);
}
