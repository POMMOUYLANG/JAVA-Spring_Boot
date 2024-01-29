package com.syntaxerror.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.demo.entity.User;
import com.syntaxerror.demo.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;

	@GetMapping("/allUsers")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users = null;
		try {
			users = userService.getAllUsers();
		}catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<List<User>>(users,HttpStatus.OK);
	}
	
	@GetMapping("/getById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int userId){
		User users = null;
		try {
			users = userService.getUserById(userId);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<User>(users,HttpStatus.OK);
	}
	
	@PostMapping("/addOrUpdate")
	public ResponseEntity<User> addOrUpdateUser(@RequestBody User user){
		User users = null;
		try {
			users = userService.addOrUpdateUser(user);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<User>(users,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable("id") int userId){
		User users = null;
		try {
			users = userService.deleteUser(userId);
		}catch(Exception ex) {
			ex.getMessage();
		}
		return new ResponseEntity<User>(users,HttpStatus.OK);
	}
	
}
