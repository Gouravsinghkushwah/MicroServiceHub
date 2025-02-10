package com.user.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.user.entity.User;

public interface UserService {

	
	// create
	User saveUser(User user);
	
	// get all user
	List<User> getAllUser();
	
	
	
	// get Single user
	User getSingleUser(String id);
	
	// delete
	String deleteUser(String id);
	
	// update
	String updateUser(User iduser);
	
	
	
}
