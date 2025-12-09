package com.ratings.RatingMicroservice.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ratings.RatingMicroservice.Entities.Rating;
import com.ratings.RatingMicroservice.Repository.RatingRepository;
@Service
public class RatingServiceImpl implements RatingService{
	@Autowired
	public RatingRepository ratingRepository;
	@Override
	public Rating createRating(Rating rating) {
		rating.setRatingId(UUID.randomUUID().toString());
		return ratingRepository.save(rating);
	}

	@Override
	public List<Rating> getRatingByUserID(String id) {
		
		return ratingRepository.findByUserId(id);
	}

	@Override
	public List<Rating> getRatingByHotelID(String id) {
		
		return ratingRepository.findByHotelId(id);
	}

	@Override
	public List<Rating> getAllRating() {
		return ratingRepository.findAll();
	}

}
