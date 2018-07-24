package com.ecommerce.DAO.impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.DAO.ProductDetailsDAO;
import com.ecommerce.beans.Products;
import com.ecommerce.exceptions.ProductNotFoundException;

@Repository
public class ProductDetailsDAOimpl implements ProductDetailsDAO {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	
	public List<Products> getProductDetails(String productName)throws Exception{
		List<Products> products = new ArrayList<Products>();
		Query query = new Query();
		query.addCriteria(Criteria.where("productName").in(productName));
		products.addAll(mongoTemplate.find(query, Products.class));
		
		if(products.isEmpty()){
			throw new ProductNotFoundException(" Expected Product"+productName+" is Not available");
		}
		
		
		return products;
	}

}
