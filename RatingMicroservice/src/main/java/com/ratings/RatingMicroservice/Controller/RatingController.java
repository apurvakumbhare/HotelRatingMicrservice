package com.ratings.RatingMicroservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ratings.RatingMicroservice.Entities.Rating;
import com.ratings.RatingMicroservice.services.RatingServiceImpl;

@RestController
@RequestMapping("/RatingMicroservice")
public class RatingController {
	@Autowired
	public RatingServiceImpl ratingServiceImpl;
	@PostMapping("/CreateRating")
	public ResponseEntity<Rating> CreateRating(@RequestBody Rating rating){
		return ResponseEntity.status(HttpStatus.CREATED).body(ratingServiceImpl.createRating(rating));
	}
	@GetMapping("/getRatingByUserID/{id}")
	public ResponseEntity<Optional<List<Rating>>> getRatingByUserID(@PathVariable String id){
		Optional<List<Rating>> Ratings =Optional.of(ratingServiceImpl.getRatingByUserID(id));
		return ResponseEntity.status(HttpStatus.OK).body(Ratings);
	}
	@GetMapping("/getRatingByHotelID/{id}")
	public ResponseEntity<Optional<List<Rating>>> getRatingByHotelID(@PathVariable String id){
		Optional<List<Rating>> Ratings =Optional.of(ratingServiceImpl.getRatingByHotelID(id));
		return ResponseEntity.status(HttpStatus.OK).body(Ratings);
	}
	@GetMapping("/getRatings")
		public ResponseEntity<Optional<List<Rating>>> getAllRating(){
			Optional<List<Rating>> Ratings =Optional.of(ratingServiceImpl.getAllRating());
			return ResponseEntity.status(HttpStatus.OK).body(Ratings);
		}
	
}
