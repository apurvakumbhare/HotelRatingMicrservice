package com.Hotels.HotelMicroservice.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Hotels.HotelMicroservice.Entites.Hotel;
import com.Hotels.HotelMicroservice.service.HotelServiceImpl;


@RestController
@RequestMapping("/HotelMicroservice")
public class HotelController {
	@Autowired
	public HotelServiceImpl hotelServiceImpl;
	
	@PostMapping("/CreateHotel")
	public ResponseEntity<Hotel> CreateHotel(@RequestBody Hotel Hotel){
		Hotel userCreated =hotelServiceImpl.createHotel(Hotel);
		return ResponseEntity.status(HttpStatus.CREATED).body(userCreated);
	}
	
	@GetMapping("/getHotel/{Id}")
	public ResponseEntity<Hotel> getHotelById(@PathVariable String Id){
		Hotel Hotel =hotelServiceImpl.getHotelByHotelId(Id);
		return ResponseEntity.status(HttpStatus.OK).body(Hotel);
	}
	@GetMapping("/getHotel")
	public ResponseEntity<Optional<List<Hotel>>> GetListOfHotel(){
		Optional<List<Hotel>> Hotels =Optional.of(hotelServiceImpl.getHotels());
		return ResponseEntity.status(HttpStatus.OK).body(Hotels);
	}
}
