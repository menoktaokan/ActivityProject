package com.app.dao;

import java.util.List;

import com.app.entity.Comment;

public interface CommentDao {
		
	public List<Comment> getActivityList(int id);
	
	public void addComment(Comment command);
	
	public int deleteComment(int id);
	
//	public void updateCommand();
	
	
}
