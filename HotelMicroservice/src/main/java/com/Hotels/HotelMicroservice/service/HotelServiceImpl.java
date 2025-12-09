package com.Hotels.HotelMicroservice.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hotels.HotelMicroservice.Entites.Hotel;
import com.Hotels.HotelMicroservice.Exception.ResourceNotFoundException;
import com.Hotels.HotelMicroservice.Repository.HotelRepository;

@Service
public class HotelServiceImpl implements HotelService{

	@Autowired
	public HotelRepository hotelRepository;
	
	@Override
	public Hotel createHotel(Hotel hotel) {
		hotel.setId(UUID.randomUUID().toString());
		return hotelRepository.save(hotel);
	}

	@Override
	public Hotel getHotelByHotelId(String id) {
		return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Could not found hotel with given id on server"));
	}

	@Override
	public List<Hotel> getHotels() {
		return hotelRepository.findAll();
	}

	
}
