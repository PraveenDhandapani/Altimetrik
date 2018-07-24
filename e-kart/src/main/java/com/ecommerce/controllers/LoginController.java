package com.ecommerce.controllers;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.beans.Users;
import com.ecommerce.exceptions.UserAlreadyExistsException;
import com.ecommerce.exceptions.UserNotFoundException;
import com.ecommerce.service.AuthenticationService;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	
	@Autowired
	private AuthenticationService authenticationService;
	
	@RequestMapping(value="/newUser", method=RequestMethod.POST)
	public ResponseEntity<String> newUser(@RequestBody Users user){
		try{
		return new ResponseEntity<String>(authenticationService.newUser(user), HttpStatus.CREATED);
		}catch(UserAlreadyExistsException e){
			return new ResponseEntity<String>("User Already Exists",HttpStatus.BAD_REQUEST);
		}catch(SQLException e){
			return new ResponseEntity<String>("DB service may not be available now", HttpStatus.SERVICE_UNAVAILABLE);
		}catch(Exception e){
			return new ResponseEntity<String>("Service is broken", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value="/user/{userName}", method=RequestMethod.GET)
	public ResponseEntity<Users> login(@PathVariable("userName") String userName) {
		Users user;
		try{
			user = authenticationService.getUserByID(userName);
			return new ResponseEntity<Users>(user, HttpStatus.OK);
		}catch(UserNotFoundException e){
			return new ResponseEntity<Users>( HttpStatus.NO_CONTENT);
		}catch(SQLException e){
			return new ResponseEntity<>( HttpStatus.SERVICE_UNAVAILABLE);
		}catch(Exception e){
			return new ResponseEntity<Users>(HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
