package com.example.demo.login_security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired private UserRepository empRepo;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    User emp = empRepo.findByUsername(username);
    if (emp == null) {
      throw new UsernameNotFoundException("No user found for the given username");
    }
    return new CustomUserDetails(emp);
  }

}
