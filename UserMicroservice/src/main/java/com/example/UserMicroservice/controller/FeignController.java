package com.example.UserMicroservice.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.UserMicroservice.Entities.Rating;
@Service
@FeignClient(name="RATINGMICROSERVICE")
public interface FeignController {

	@GetMapping("/RatingMicroservice/getRatingByUserID/{UserID}")
	public  List<Rating> getRatings(@PathVariable String UserID);
}
