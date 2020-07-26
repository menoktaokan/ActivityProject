package com.app.restcontroller;

import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.app.model.Activity;
import com.app.model.CheckList;
import com.app.model.Comment;


@Component
public class RestClient {
	
	static final String activitiesServerUrl = "http://localhost:8186/activities/";

	static final String commentsServerUrl = "http://localhost:8187/";
	
	static final String CheckListServerUrl = "http://localhost:8188/checkUser";
	
	static RestTemplate restTemplate = new RestTemplate();
	
	public List<Activity> getActivities(){
		ResponseEntity<List<Activity>> respEntity=
		restTemplate.exchange(activitiesServerUrl, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Activity>>() {
				});
		
		return respEntity.getBody();
	}
	
	public Activity getActivityById(int id) {

		return restTemplate.getForObject(activitiesServerUrl + id, Activity.class);
	}
	
	public List<Comment> getComments(int ida){
		ResponseEntity<List<Comment>> respEntity=
		restTemplate.exchange(commentsServerUrl+"list/" + ida, HttpMethod.GET, null, 
				new ParameterizedTypeReference<List<Comment>>() {
				});
		
		return respEntity.getBody();
	}
	
	public  ResponseEntity<CheckList> checForkUser(CheckList checkUser) {

		return restTemplate.postForEntity(CheckListServerUrl, checkUser, CheckList.class);
	}

	public  ResponseEntity<Comment> addComment(Comment comment) {

		return restTemplate.postForEntity(commentsServerUrl +"addcomment", comment, Comment.class);
	}
	

	public Integer deleteComment(int id) {

		return restTemplate.getForObject(commentsServerUrl+"delete-comment/" + id, Integer.class);
	}
	

}
