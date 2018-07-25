package com.ecommerce.DAO.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.DAO.CartServiceDAO;
import com.ecommerce.beans.Cart;

@Repository
public class CartServiceDAOimpl implements CartServiceDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	public List<Cart> getCartDetails(String userId){
		
		List<Cart> productList = new ArrayList<Cart>();
		
		Query query = new Query();
		query.addCriteria(Criteria.where("userId").in(userId));
		query.addCriteria(Criteria.where("status").in("inCart"));
		productList.addAll(mongoTemplate.find(query, Cart.class));
		
		return productList;
	}
	
	public String addToCart(List<Cart> cart){
		mongoTemplate.insertAll(cart);
		return "";
	}

}
