package com.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.ActivityRepository;
import com.app.model.Activity;

@Service
public class ActivityServiceImpl implements IActivityService {

	private ActivityRepository activityRepository;

	@Autowired
	public ActivityServiceImpl(ActivityRepository theactivityRepository) {
		activityRepository = theactivityRepository;
	}

	@Override
	public Activity getActivityById(int id) {
		Optional<Activity> result = activityRepository.findById(id);
		Activity theAct = null;
		if (result.isPresent()) {
			theAct = result.get();
		} else {
			// we didn't find the employee
			throw new RuntimeException("Did not find employee id - " + id);
		}
		return theAct;
		
	}

	@Override
	public List<Activity> getAllActivities() {

		return activityRepository.findAll();
	}

	@Override
	public void saveOrUpdateActivity(Activity act) {
		activityRepository.save(act);
	}

	@Override
	public void deleteActivity(Activity act) {
		activityRepository.delete(act);

	}

}
