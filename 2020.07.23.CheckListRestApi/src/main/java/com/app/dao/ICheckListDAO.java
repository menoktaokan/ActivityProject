package com.app.dao;

import java.util.List;

import com.app.entity.CheckList;

public interface ICheckListDAO {
	
	public void checForkUser(CheckList checkUser);

	public List<CheckList> getAllList();

}
