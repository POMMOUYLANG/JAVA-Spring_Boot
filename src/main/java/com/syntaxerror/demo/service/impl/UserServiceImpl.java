package com.syntaxerror.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.syntaxerror.demo.entity.User;
import com.syntaxerror.demo.repository.UserRepository;
import com.syntaxerror.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository userRepository; 

	@Override
	public List<User> getAllUsers() {
		return (List<User>) userRepository.findAll();
	}

	@Override
	public User getUserById(int userId) {
		return userRepository.findById(userId).orElse(null);
	}

	@Override
	public User addOrUpdateUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User deleteUser(int userId) throws Exception {
		User deletedUser = null;
		try {
			deletedUser = userRepository.findById(userId).orElse(null);
			if(deletedUser == null) {
				throw new Exception("user not available");
			}else {
				userRepository.deleteById(userId);
			}
		}catch(Exception ex) {
			throw ex;
		}
		return deletedUser;
	}

}
