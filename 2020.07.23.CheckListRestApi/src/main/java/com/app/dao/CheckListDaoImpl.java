package com.app.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.app.entity.CheckList;

@Repository
public class CheckListDaoImpl implements ICheckListDAO {
	
	private EntityManager entityManager;
	
	@Autowired
	public CheckListDaoImpl(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void checForkUser(CheckList checkUser) {
		Session session = entityManager.unwrap(Session.class);
		session.saveOrUpdate(checkUser);

	}

	@Override
	public List<CheckList> getAllList() {
		Session session = entityManager.unwrap(Session.class);
		
		return session.createQuery("from CheckList ", CheckList.class)
				.getResultList();
	}

}
