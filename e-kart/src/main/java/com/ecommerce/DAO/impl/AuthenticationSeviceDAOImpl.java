package com.ecommerce.DAO.impl;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.DAO.AuthenticationSeviceDAO;
import com.ecommerce.beans.Users;
import com.ecommerce.exceptions.UserAlreadyExistsException;
import com.ecommerce.exceptions.UserNotFoundException;

@Repository
public class AuthenticationSeviceDAOImpl implements AuthenticationSeviceDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public String newUser(Users user) throws Exception{
		Users existingUser;
		existingUser = this.getUserByID(user.getUsername());
		if(existingUser!=null){
			throw new UserAlreadyExistsException("The user details is already exists");
		}
		 mongoTemplate.save(user);
		
		 return "Success";
	}
	
	@Override
	public Users getUserByID(String userName) throws UserNotFoundException,SQLException{
		Query query = new Query();
		Users user = new Users();
		query.addCriteria(Criteria.where("username").is(userName));
		user =  mongoTemplate.findOne(query, Users.class);
		if(user == null){
			throw new UserNotFoundException("User not found for requested User Id "+userName);
		}
		
		return user;
	}

	
}
