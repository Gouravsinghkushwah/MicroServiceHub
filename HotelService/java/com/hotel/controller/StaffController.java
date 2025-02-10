package com.hotel.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/staff")
public class StaffController {
	
	@GetMapping
	public ResponseEntity<List<String>> getStaffs()
	{
		List<String> staffList = Arrays.asList("Pawan","Sumit","Ram","Meena","riya");
		return new ResponseEntity<>(staffList, HttpStatus.OK);
	}

}
