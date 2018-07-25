package com.ecommerce.DAO;

import java.util.List;

import com.ecommerce.beans.Cart;

public interface CartServiceDAO {
	
	public List<Cart> getCartDetails(String userId);
	
	public String addToCart(List<Cart> cart);

}
