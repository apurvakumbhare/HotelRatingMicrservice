package com.example.UserMicroservice.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserMicroservice.Entities.User;
import com.example.UserMicroservice.Service.UserService;
import com.example.UserMicroservice.Service.UserServiceImpl;

import jakarta.persistence.PostPersist;

@RestController
@RequestMapping("/UserMicroservice")
public class UserController {
	@Autowired
	private UserServiceImpl service;
	@PostMapping("/CreateUser")
	public ResponseEntity<User> CreateUser(@RequestBody User user){
		User userCreated =service.createUser(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}
	
	@GetMapping("/getUser/{Id}")
	public ResponseEntity<User> getUserById(@PathVariable String Id){
		User user =service.getUserById(Id);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	@GetMapping("/getUser")
	public ResponseEntity<Optional<List<User>>> GetListOfUser(){
		Optional<List<User>> users =Optional.of(service.getAllUsers());
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
}
