package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.app.entity.Comment;

@Repository
public class CommentDaoImpl implements CommentDao {

	private EntityManager entityManager;
	
	
	@Autowired
	public CommentDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public List<Comment> getActivityList(int id) {
		Session session = entityManager.unwrap(Session.class);
		
		List<Comment> commands = session.createQuery("from Comment where ACTIVITY_ID="+id+" and status=1",Comment.class)
				.getResultList();
		return commands;
	}

	@Override
	public void addComment(Comment command) {
		Session session = entityManager.unwrap(Session.class);
		
		session.save(command);
		
	}

	@Override
	public int deleteComment(int id) {
		Session session = entityManager.unwrap(Session.class);
		return session.createQuery("update Comment set status = 0 where id ="+id).executeUpdate();
	}

}
