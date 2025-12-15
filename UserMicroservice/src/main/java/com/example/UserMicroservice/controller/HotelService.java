package com.example.UserMicroservice.controller;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.UserMicroservice.Entities.Hotel;

@Service
@FeignClient(name = "HOTELMICROSERVICE")
public interface HotelService {
	@GetMapping ("/HotelMicroservice/getHotel/{hotelId}")
	public Hotel getHotelByHotelId(@PathVariable String hotelId);
}
