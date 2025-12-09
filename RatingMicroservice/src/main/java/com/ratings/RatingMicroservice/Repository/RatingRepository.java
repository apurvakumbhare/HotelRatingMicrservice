package com.ratings.RatingMicroservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ratings.RatingMicroservice.Entities.Rating;

public interface RatingRepository extends JpaRepository<Rating, String>{

	//custom finder Methods 
	public List<Rating> findByUserId(String userId);
	public List<Rating> findByHotelId(String hotelId);

}
