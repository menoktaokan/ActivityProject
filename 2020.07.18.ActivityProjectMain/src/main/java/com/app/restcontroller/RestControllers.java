package com.app.restcontroller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllers {
	
	@GetMapping("/plain")
	public String plain() {
		return "plain rest return";
	}

	@GetMapping("/user")
	public String users() {
		return "<h2>Welcome user</h2>";
	}

	@GetMapping("/admin")
	public String admins() {
		return "<h1>Welcome Admin </h1>";
	}
}
