package com.example.UserMicroservice.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.UserMicroservice.PayLoad.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> handleResourceNotFoundException(ResourceNotFoundException ex){
		String msg=ex.getMessage();
		ApiResponse apiResponse= ApiResponse.builder().message(msg).status(HttpStatus.NOT_FOUND).Success(true).build();
		return new ResponseEntity<>(apiResponse,HttpStatus.NOT_FOUND);
	}
	
}
