package com.ecommerce.service;

import java.sql.SQLException;

import com.ecommerce.beans.Users;
import com.ecommerce.exceptions.UserNotFoundException;

public interface AuthenticationService {
	
	public String newUser(Users user) throws Exception;
	
	public Users getUserByID(String userName) throws UserNotFoundException,SQLException;

}
