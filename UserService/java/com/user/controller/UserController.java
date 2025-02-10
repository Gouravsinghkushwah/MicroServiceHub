package com.user.controller;

 
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.entity.User;
import com.user.entity.User.UserBuilder;
import com.user.service.UserService;
import com.user.serviceImpl.ServiceImpl;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
 

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	
	
	
	
	private Logger logger =  LoggerFactory.getLogger(UserController.class);

	
	@PostMapping
	public ResponseEntity<User> createUser(@RequestBody User user)
	{
		
		
		User saveUser = userService.saveUser(user);
		return  ResponseEntity.status(HttpStatus.CREATED).body(saveUser);
	}
	int retryCount=0;
	
	@GetMapping("/{userId}")
	// @CircuitBreaker(name ="ratingHotelBreaker", fallbackMethod = "ratingHotelfallback")
//	@Retry(name = "ratingHotelService", fallbackMethod = "ratingHotelfallback")
	@RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelfallback")
	public ResponseEntity<User> getMethodName(@PathVariable String userId ) {
		
		logger.info("retry count: {}",retryCount);
		retryCount++;
		
 		User singleUser = userService.getSingleUser(userId);
  		return ResponseEntity.ok(singleUser);
 	}

	// fallback method for circuitbreaker
	public  ResponseEntity<User> ratingHotelfallback(String userId, Exception ex)
	{
	 logger.info("FallBack executed because service is down", ex.getMessage());	
	 
	 User user = User.builder().email("dummy@gmail.com")
			 .name("Dummy")
			 .about("Dummy user created because service is down")
			 .userId("12345").build();
	 return ResponseEntity.ok(user);
	}
	
	
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers()
	{
		List<User> allUser = userService.getAllUser();
		return ResponseEntity.ok(allUser); 
	}
	

}
