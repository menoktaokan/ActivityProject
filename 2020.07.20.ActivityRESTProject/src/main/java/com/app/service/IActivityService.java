package com.app.service;

import java.util.List;

import com.app.model.Activity;

public interface IActivityService {
	
	public Activity getActivityById(int id);
	
	public List<Activity> getAllActivities();
	
	public void saveOrUpdateActivity(Activity act);
	
	public void deleteActivity(Activity act);

}
