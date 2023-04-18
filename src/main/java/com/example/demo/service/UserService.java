package com.example.demo.service;

import com.example.demo.entity.User;

public interface UserService {
	
	public boolean userRegister(User user);
	public User getUser(String userId);
	public boolean deleteUser(int id);
}
