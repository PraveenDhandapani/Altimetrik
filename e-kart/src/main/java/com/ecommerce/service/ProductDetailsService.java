package com.ecommerce.service;

import java.util.List;


import com.ecommerce.beans.Products;


public interface ProductDetailsService {
	
	public List<Products> getProductDetails(String productName)throws Exception;

}
