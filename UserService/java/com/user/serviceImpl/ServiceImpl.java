package com.user.serviceImpl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.user.entity.Hotel;
import com.user.entity.Rating;
import com.user.entity.User;
import com.user.exceptions.ResourceNotFoundException;
import com.user.external.service.HotelService;
import com.user.repo.UserRepo;
import com.user.service.UserService;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class ServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private HotelService hotelService;
	
	@Autowired
	private RestTemplate restTemplate;
	private Logger logger = LoggerFactory.getLogger(ServiceImpl.class);

	@Override
	public User saveUser(User user) {

		String randomUserId = UUID.randomUUID().toString(); // Unique user ID
		user.setUserId(randomUserId);
		return userRepo.save(user);
	}

	@Override 
	public List<User> getAllUser() {

		List<User> allUsers = userRepo.findAll();

//		for (User user : allUsers) {
//			ArrayList<Rating> ratingOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/" +user.getUserId(), ArrayList.class);
//			user.setRatings(ratingOfUser);
//		}
		allUsers.forEach(user -> {
			ArrayList<Rating> ratingUser =  restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" +user.getUserId(), ArrayList.class);
			user.setRatings(ratingUser);
		});

		return allUsers;
	}

	// get single user
	@Override
	public User getSingleUser(String id) {

		// get user from DB with the help of user repository
		User userObj = userRepo.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException(" User not found with this id " + id));

		// fetch rating of the above user from Rating service
		// http://localhost:8083/ratings/users/08a2332b-fc53-4a5e-acea-8468c2abe83c

		 Rating[] ratingOfUser = restTemplate.getForObject("http://RATINGSERVICE/ratings/users/" + id, Rating[].class);
		
		 logger.info("{} ", ratingOfUser); 
		 List<Rating> ratinglist = Arrays.stream(ratingOfUser).toList();
		List<Rating> ratingList = ratinglist.stream().map(rating -> {
			//http://localhost:8082/hotels/723c386e-6869-4332-9400-57f51fb4ba8d
			System.out.println(rating.toString()+"--------------------"+rating.getHotelId());
			
//			ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTELSERVICE/hotels/"+rating.getHotelId(),Hotel.class);
			Hotel hotel = hotelService.getHotel(rating.getHotelId());
//			logger.info("Response Status code {} ", forEntity.getStatusCode());
			//set the hotel to rating
			// return return 
			rating.setHotel(hotel);
			
			return rating;
			
		}).collect(Collectors.toList());
		
		userObj.setRatings(ratingList);
		return userObj;
	}

	@Override
	public String deleteUser(String id) {
		userRepo.deleteById(id);
		return " Deteled";
	}

	@Override
	public String updateUser(User user) {
		userRepo.save(user);
		return "Updatred";
	}

//	public ResponseEntity<User> saveUser(@RequestBody User user)
//	{
//		if(!userRepo.existsById(user.getUserId()))
//		{
//			service.
//		}
//	}

}
