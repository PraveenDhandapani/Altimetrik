package com.ecommerce.DAO;


import java.sql.SQLException;

import com.ecommerce.beans.Users;
import com.ecommerce.exceptions.UserNotFoundException;

public interface AuthenticationSeviceDAO {
	
	public String newUser(Users user)throws Exception;
	
	public Users getUserByID(String userName) throws UserNotFoundException,SQLException;

}
