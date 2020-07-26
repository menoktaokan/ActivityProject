package com.app.service;

import java.util.List;

import com.app.entity.CheckList;

public interface ICheckListService {
	
	public void checForkUser(CheckList checkUser);

	public List<CheckList> getAllList();


}
