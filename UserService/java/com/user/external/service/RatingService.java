package com.user.external.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

import com.user.entity.Rating;


@FeignClient(name = "RATINGSERVICE")
public interface RatingService {
	
	
	// Post
	@PostMapping("/ratings")
	public Rating createRating(Rating rating);
	
	// Put
	public Rating updateRating(Rating rating);

}
