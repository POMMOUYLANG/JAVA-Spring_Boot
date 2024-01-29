package com.syntaxerror.demo.service;

import java.util.List;

import com.syntaxerror.demo.entity.User;

public interface UserService {

	public List<User> getAllUsers();
	public User getUserById(int userId);
	public User addOrUpdateUser(User user);
	public User deleteUser(int userId) throws Exception;
	
}
