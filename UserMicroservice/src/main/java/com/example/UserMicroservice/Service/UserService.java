package com.example.UserMicroservice.Service;

import java.util.List;

import com.example.UserMicroservice.Entities.User;

public interface UserService {

	public User createUser(User user);
	public User getUserById(String id);
	public List<User> getAllUsers();
	
	
}
