package com.ratings.RatingMicroservice.services;

import java.util.List;

import com.ratings.RatingMicroservice.Entities.Rating;

public interface RatingService {

	public Rating createRating(Rating rating);
	public List<Rating> getRatingByUserID(String id);
	public List<Rating> getRatingByHotelID(String id);
	public List<Rating> getAllRating();
	
}
