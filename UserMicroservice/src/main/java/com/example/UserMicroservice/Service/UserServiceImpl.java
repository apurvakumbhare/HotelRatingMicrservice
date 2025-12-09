package com.example.UserMicroservice.Service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.UserMicroservice.Entities.User;
import com.example.UserMicroservice.Entities.Repositories.UserRepository;
import com.example.UserMicroservice.Exception.ResourceNotFoundException;
@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserRepository repository;
	@Override
	public User createUser( User user) {
		String UserId=UUID.randomUUID().toString();
		user.setUserId(UserId);
		return repository.save(user);
	}

	@Override
	public User getUserById(String id) {
		return repository.findById(id).orElseThrow(()->new ResourceNotFoundException("User with given Id not found on Server!!!!!"));
	}

	@Override
	public List<User> getAllUsers() {
		return repository.findAll();
	}

}
