package com.ecommerce.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.DAO.AuthenticationSeviceDAO;
import com.ecommerce.beans.Users;
import com.ecommerce.exceptions.UserNotFoundException;
import com.ecommerce.service.AuthenticationService;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	private AuthenticationSeviceDAO authDAO;

	@Override
	public String newUser(Users user) throws Exception {
		return authDAO.newUser(user);
	}
	
	@Override
	public Users getUserByID(String userName) throws UserNotFoundException,SQLException{	
		return authDAO.getUserByID(userName);
	}

}
