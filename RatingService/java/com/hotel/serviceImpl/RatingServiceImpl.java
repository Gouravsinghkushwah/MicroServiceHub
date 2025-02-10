package com.hotel.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.entity.Rating;
import com.hotel.repo.RatingRepo;
import com.hotel.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	
	@Autowired
	private RatingRepo ratingRepo;

	@Override
	public Rating create(Rating rating) {
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getRatings() {
 		return ratingRepo.findAll();
	}

	
	
	
	
	
	
	@Override
	public List<Rating> getByUser(String userId) {
 		return  ratingRepo.findByUserId(userId);
	}

	@Override
	public List<Rating> getRatingByHotelId(String hotelId) {
 		return ratingRepo.findByHotelId(hotelId);
	}
	
	
	
}
