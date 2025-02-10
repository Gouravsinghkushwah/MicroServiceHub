package com.user.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.user.payload.ApiResource;

@RestControllerAdvice
public class GlobalExceptionHandler {

	
	
	
	
	
	
	
	
	
	
	
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResource> handleResourceNotFoundException(ResourceNotFoundException exception) {

		String message = exception.getMessage();
		ApiResource response = ApiResource.builder().message(message).success(true).httpStatus(HttpStatus.NOT_FOUND)
				.build();

		return new ResponseEntity<ApiResource>(response, HttpStatus.NOT_FOUND);
	}

}
