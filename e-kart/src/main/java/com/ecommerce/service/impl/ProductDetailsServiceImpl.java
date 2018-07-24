package com.ecommerce.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.DAO.ProductDetailsDAO;
import com.ecommerce.beans.Products;
import com.ecommerce.service.ProductDetailsService;

@Service
public class ProductDetailsServiceImpl implements ProductDetailsService {
	
	@Autowired
	private ProductDetailsDAO productDetailsDAO;
	
	public List<Products> getProductDetails(String productName)throws Exception{
		
		return productDetailsDAO.getProductDetails(productName);
		
	}

}
