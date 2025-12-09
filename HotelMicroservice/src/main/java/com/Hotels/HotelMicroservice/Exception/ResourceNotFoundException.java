package com.Hotels.HotelMicroservice.Exception;

public class ResourceNotFoundException extends RuntimeException{

	public ResourceNotFoundException() {
		super("Could not found resource");
	}
	public ResourceNotFoundException(String s) {
		super(s);
	}

	
	
}
