package com.hotel.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Hotel;
import com.hotel.exceptions.ResourceNotFoundException;
import com.hotel.repository.HotelRepo;

@Service
public class HotelServiceimpl implements HotelService {
	@Autowired
	private HotelRepo hotelRepo;

	@Override
	public Hotel create(Hotel hotel) {
		
 		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getHotels() {
 		return hotelRepo.findAll();
	}

	@Override
	public Hotel getHolet(String id) {
  		  return   hotelRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException(" hotel id not found "+ id));
	}

	 

}
