package com.app.service;

import java.util.List;

import com.app.model.Users;

public interface IUserService {
	public List<Users> getAllUsers();
	public void newUser(Users user);
}
