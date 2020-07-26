package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.CheckList;
import com.app.service.ICheckListService;

@RestController
public class CheckListRestController {
	
	@Autowired
	private ICheckListService checkLisrService;
	
	
	@PostMapping("/checkUser")
	public void checForkUser(@RequestBody CheckList checkUser) {
		checkLisrService.checForkUser(checkUser);
	}
	
	@GetMapping("/list")
	public List<CheckList> getAllList(){
		return 	checkLisrService.getAllList();
				
	}

}
