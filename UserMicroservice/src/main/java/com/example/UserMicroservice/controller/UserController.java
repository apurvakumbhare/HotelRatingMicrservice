package com.example.UserMicroservice.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
import org.springframework.web.client.RestTemplate;

import com.example.UserMicroservice.Entities.Hotel;
import com.example.UserMicroservice.Entities.Rating;
import com.example.UserMicroservice.Entities.User;
import com.example.UserMicroservice.Service.UserService;
import com.example.UserMicroservice.Service.UserServiceImpl;

import jakarta.persistence.PostPersist;

@RestController
@RequestMapping("/UserMicroservice")
public class UserController {
	@Autowired
	public RestTemplate restTemplate;
	public Logger logger=LoggerFactory.getLogger(UserController.class);
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
		String UserID=user.getUserId();

	    List<Rating> ratingList = new ArrayList<>();

	    try {
	        // FIX: Deserialize JSON into Rating[] instead of ArrayList<LinkedHashMap>
	        Rating[] ratingArray = restTemplate.getForObject(
	                "http://RATINGMICROSERVICE/RatingMicroservice/getRatingByUserID/" + UserID,
	                Rating[].class
	        );

	        if (ratingArray != null) {
	            ratingList = List.of(ratingArray);
	        }

	    } catch (Exception e) {
	        logger.error("Rating service down or invalid response", e);
	    }

	    logger.info("Ratings: {}", ratingList);
	    for (Rating rating : ratingList) {
	        try {
	            Hotel hotel = restTemplate.getForObject(
	                    "http://HOTELMICROSERVICE/HotelMicroservice/getHotel/" + rating.getHotelId(),
	                    Hotel.class
	            );
	            rating.setHotel(hotel);
	        } catch (Exception e) {
	            logger.error("Hotel service failed for hotel ID: " + rating.getHotelId(), e);
	        }
	    }
		user.setRatings(ratingList);
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
	@GetMapping("/getUser")
	public ResponseEntity<Optional<List<User>>> GetListOfUser(){
		Optional<List<User>> users =Optional.of(service.getAllUsers());
		return ResponseEntity.status(HttpStatus.OK).body(users);
	}
	
}
