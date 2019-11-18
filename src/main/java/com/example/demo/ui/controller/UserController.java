package com.example.demo.ui.controller;


import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.example.demo.ui.model.request.UpdateUserRequestModel;
import com.example.demo.ui.model.request.UserDetailRequestModel;
import com.example.demo.ui.model.response.UserRest;

@RestController
@RequestMapping("users")
public class UserController {
	
	Map<String, UserRest> users;
	
	@GetMapping
	public String getUser(
			@RequestParam(value="page", defaultValue = "1") int page, 
			@RequestParam(value="length") int length,
			@RequestParam(value="sort", required = false, defaultValue = "desc") String sort) {
		return "getUser Called with query params page " + page + " and length " + length + " and sort " + sort;
	}
	
	@GetMapping(path="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest>  getUser(@PathVariable String userId) {
		
		if(users != null) {
			return new ResponseEntity<UserRest>(users.get(userId), HttpStatus.OK);
		} else {
			return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
		}
	}
	
	@PostMapping(consumes = { MediaType.APPLICATION_XML_VALUE, 
		MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, 
					MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserRest> createUser(@Valid @RequestBody UserDetailRequestModel userDetail) {
		UserRest userRest = new UserRest();
		
		userRest.seteMail(userDetail.geteMail());
		userRest.setFirstName(userDetail.getFirstName());
		userRest.setLastName(userDetail.getLastName());
		
		String userId = UUID.randomUUID().toString();
		userRest.setUserId(userId);
		
		if(users == null) users = new HashMap<>();
		users.put(userId, userRest);
		
		return new ResponseEntity<UserRest>(userRest, HttpStatus.OK);	
	}
	
	@PutMapping(path="/{userId}", produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public UserRest updateUser(@PathVariable String userId, @Valid @RequestBody UpdateUserRequestModel userDetails) {
		
		UserRest storedUser = users.get(userId);
		storedUser.setFirstName(userDetails.getFirstName());
		storedUser.setLastName(userDetails.getLastName());
		
		return storedUser;
	}

	@DeleteMapping(path="/{userId}")
	public ResponseEntity<Void> deleteUser(@PathVariable String userId) {
		
		users.remove(userId);
		return ResponseEntity.noContent().build();
	}
	
}
