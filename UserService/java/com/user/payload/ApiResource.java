package com.user.payload;

import org.springframework.http.HttpStatus;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ApiResource {

	private String message;
	private boolean success;
	private HttpStatus httpStatus;

}
