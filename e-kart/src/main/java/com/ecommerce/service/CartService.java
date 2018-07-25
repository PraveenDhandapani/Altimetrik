package com.ecommerce.service;

import java.util.List;

import com.ecommerce.beans.Cart;

public interface CartService {
	
	public List<Cart> getCartDetails(String userId);
	
	public String addToCart(List<Cart> cart);

}
