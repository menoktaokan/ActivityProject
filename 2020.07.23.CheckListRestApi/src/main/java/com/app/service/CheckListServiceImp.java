package com.app.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.CheckListRepository;
import com.app.entity.CheckList;


@Service
public class CheckListServiceImp implements ICheckListService {

//	@Autowired
//	private ICheckListDAO checkListDao;
	
	private CheckListRepository checkListRep;
	
	
	@Autowired
	public CheckListServiceImp(CheckListRepository checkListRep) {
	this.checkListRep = checkListRep;
}

	@Override
	public void checForkUser(CheckList checkUser) {
		checkListRep.save(checkUser);

	}

	@Override
	public List<CheckList> getAllList() {
		
		return checkListRep.findAll();
	}

}
