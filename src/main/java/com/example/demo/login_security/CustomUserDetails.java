package com.example.demo.login_security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.User;

public class CustomUserDetails implements UserDetails {
  private User emp;

  public CustomUserDetails(User emp) {
    this.emp = emp;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // Set<Role> roles = user.getRoles();
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(emp.getRole()));
    return authorities;
  }

  public boolean hasRole(String roleName) {
    return this.emp.hasRole(roleName);
  }

  @Override
  public String getPassword() {
    return emp.getPassword();
  }

  @Override
  public String getUsername() {
    return emp.getUsername();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
