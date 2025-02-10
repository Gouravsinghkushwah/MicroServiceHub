package com.hotel.service;

import java.util.List;

import com.hotel.entity.Rating;

public interface RatingService {

	// create 
	
	Rating create(Rating rating);
	
	// get all rating
	List<Rating> getRatings();
	
	
	
	
	
	
	
	
	// get rating by user 
	List<Rating> getByUser(String userId);
	
	
	// get all by hotel
	List<Rating> getRatingByHotelId(String hotelId);
	
	
	
	
	
	
}
