package com.app.controller;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.model.Activity;
import com.app.model.CheckList;
import com.app.model.Comment;
import com.app.model.Users;
import com.app.restcontroller.RestClient;
import com.app.service.IUserService;

@Controller
public class BasicController {
	
	private static int activityId;

	@Autowired
	public BasicController(IUserService userService, RestClient restClient) {
		this.userService = userService;
		this.restClient = restClient;
	}
	
	private List<Users> allUsers;
	private IUserService userService;
	private RestClient restClient;

	@GetMapping("/home")
	public String home() {
		return "home";
	}

	@GetMapping("/")
	public String index(Model model) {
//		model.addAttribute("activities", restClient.getActivities());
		model.addAttribute("theAct", new Activity(0, null, "Please  choose an activity to see the details.", null, 1));
		return "index";
	}

	@GetMapping("/act-choose")
	public String showActivity(@RequestParam("actId") int actId, Model model) {
//		List<Activity> listActivity = restClient.getActivities();
//		model.addAttribute("activities", listActivity);
		activityId=actId;
		model.addAttribute("comments", restClient.getComments(actId));
		model.addAttribute("theAct", restClient.getActivityById(actId));

		return "index";
	}

	@GetMapping("/activity")
	public String getActivity(@RequestParam("actId") int actId, Model model) {
//		model.addAttribute("activities", restClient.getActivities());
		activityId=actId;
		model.addAttribute("comments", restClient.getComments(actId));
		model.addAttribute("theAct", restClient.getActivityById(actId));

		return "index";
	}

	@GetMapping("/check-in")
	public String checkIn(@RequestParam("username") String username, @RequestParam("actId") int actId, Model model) {
		activityId=actId;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		restClient.checForkUser(new CheckList(actId, auth.getName()));

//		model.addAttribute("activities", restClient.getActivities());
		model.addAttribute("theAct", restClient.getActivityById(actId));
		model.addAttribute("comments", restClient.getComments(actId));
		
		return "index";
	}

	@GetMapping("/new-user")
	public String newUser(Model model) {
		model.addAttribute("user", new Users());
		return "new-user";
	}

	@PostMapping("/new-user/singup")
	public String singUp(@ModelAttribute("user") Users user, Model model, BindingResult br) {
		try {
			user.setRole("USER");
			user.setStatus(1);
			userService.newUser(user);
		} catch (org.springframework.dao.DataIntegrityViolationException e) {
			System.out.println("kullanıcı adı ya da nickname çakıştı");
			br.rejectValue("username", "error.users", "Username or nickname is used already!");
			return "new-user";
		}
		return "redirect:/";
	}
	
	@RequestMapping("/new-comment")
	public String addComment(@ModelAttribute("comment") Comment comment, Model model) {
		if(comment.getCommentDetails().trim()==null || comment.getCommentDetails().trim().equals("")) {
			
		}
		else {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			java.util.Date date=new java.util.Date();  
			allUsers=userService.getAllUsers();
			for (Users users : allUsers) {
				if(users.getUsername().equals(auth.getName()))
					comment.setNickname(users.getNickname());
			}
			comment.setStatus(1);
			comment.setActivityId(activityId);
			comment.setCommentDate(date);
			
			restClient.addComment(comment);

		}
		
		return "redirect:/act-choose?actId="+activityId;
	}
	
	@GetMapping("/delete-comment")
	public String deleteComment(@RequestParam("commentId") int commentId ) {
		restClient.deleteComment(commentId);
		return "redirect:/act-choose?actId="+activityId;
		
	}

	@ModelAttribute("activities")
	public List<Activity> allActivities() {
		return restClient.getActivities();
	}
	
	@ModelAttribute("comment")
	public Comment newComment() {
		return new Comment();
	}
	
	@ModelAttribute("nickname")
	public String nicknames() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		allUsers=userService.getAllUsers();
		for (Users users : allUsers) {
			if(users.getUsername().equals(auth.getName()))
				return users.getNickname();
		}
		return null;
	}

}
