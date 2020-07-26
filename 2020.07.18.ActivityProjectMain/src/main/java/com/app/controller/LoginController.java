package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.app.model.Users;
import com.app.restcontroller.RestClient;

@Controller
public class LoginController {

	private RestClient restClient;

	@Autowired
	public LoginController(RestClient restClient) {

		this.restClient = restClient;
	}

	@GetMapping("/loginForm")
	public String showLogin() {
		return "custom-login";
	}

	@GetMapping("/accessDenied")
	public String accessDenied() {
		return "access-denied";
	}


}
