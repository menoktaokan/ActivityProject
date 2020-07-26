package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.dao.CommentDao;
import com.app.entity.Comment;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Autowired
	private CommentDao commentdao;
	
	@Override
	public List<Comment> getActivityList(int id) {
		
		return commentdao.getActivityList(id);
	}

	@Transactional
	@Override
	public void addComment(Comment command) {
		
		commentdao.addComment(command);
		
	}

	@Transactional
	@Override
	public int deleteComment(int id) {
		return commentdao.deleteComment(id);
		
	}

}
