package com.app.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.model.Activity;
import com.app.service.IActivityService;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class ServerRestController {
	
	@Autowired
	private IActivityService activityService;
	
	@RequestMapping("/")
	public String route() {
		return "route";
	}
	
	@GetMapping("/activities")
	public List<Activity> getActivities(){

		return activityService.getAllActivities();
	}
	
	@GetMapping("/activities/{id}")
	public Activity getActivityById(@PathVariable Integer id) {
		
		return activityService.getActivityById(id);
	}
	

}
