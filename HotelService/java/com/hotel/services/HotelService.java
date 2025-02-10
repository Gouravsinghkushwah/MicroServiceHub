package com.hotel.services;

import java.util.List;

import com.hotel.entity.Hotel;

public interface HotelService {

	Hotel create(Hotel hotel);
	
	List<Hotel> getHotels();
	
	Hotel getHolet(String id);
	
	
}
