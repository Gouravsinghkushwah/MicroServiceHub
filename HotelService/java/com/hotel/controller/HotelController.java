package com.hotel.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hotel.entity.Hotel;
import com.hotel.services.HotelService;

@RestController
@RequestMapping("/hotels")
public class HotelController {
	
	@Autowired
	private HotelService hotelService;
	
	
	
	
	
	
	
	
	
	
	
	
	@PostMapping
	public ResponseEntity<Hotel> crateHotel(@RequestBody Hotel hotel)
	{
		String hotelID = UUID.randomUUID().toString();
		hotel.setId(hotelID);
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
	}
	
	
	@GetMapping("/{id}")
	public ResponseEntity<Hotel> getHotel(@PathVariable String id) {
		return  ResponseEntity.status(HttpStatus.OK).body(hotelService.getHolet(id));
	}
	
	@GetMapping
	public ResponseEntity<List<Hotel>> getHotels()
	{
		return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotels());
	}
	

}
