package com.hotel.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.hotel.entity.Rating;

@Repository
public interface RatingRepo extends MongoRepository<Rating, String> {

 	public List<Rating> findByUserId(String userId);
 	
 	public List<Rating> findByHotelId(String hotelId);
	
}
