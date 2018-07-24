package com.ecommerce.DAO;

import java.util.List;

import com.ecommerce.beans.Products;

public interface ProductDetailsDAO {
	
	public List<Products> getProductDetails(String productName)throws Exception;

}
