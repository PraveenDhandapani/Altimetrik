package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.DAO.CartServiceDAO;
import com.ecommerce.beans.Cart;
import com.ecommerce.service.CartService;

@Service
public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartServiceDAO cartDAO;
	
	public List<Cart> getCartDetails(String userId){
		
		return cartDAO.getCartDetails(userId);
	}
	
	public String addToCart(List<Cart> cart){
		return cartDAO.addToCart(cart);
	}

}
