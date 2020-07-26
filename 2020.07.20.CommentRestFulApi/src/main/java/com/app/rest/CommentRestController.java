package com.app.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.entity.Comment;
import com.app.service.CommentService;

@RestController
public class CommentRestController {
	
	@Autowired
	private CommentService commentservice;
	
	@GetMapping("/list/{id}")
	public List<Comment> comments(@PathVariable("id") int id){
		
		return commentservice.getActivityList(id);
	}
	
	@PostMapping("/addcomment")
	public void addComment(@RequestBody Comment comment) {
		commentservice.addComment(comment);
	}
	
	@GetMapping("/delete-comment/{id}")
	public int deleteComment(@PathVariable("id") int id) {
		return commentservice.deleteComment(id);
	}
	

}
