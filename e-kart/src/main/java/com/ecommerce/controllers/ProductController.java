package com.ecommerce.controllers;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.beans.Products;
import com.ecommerce.exceptions.ProductNotFoundException;
import com.ecommerce.service.ProductDetailsService;


@RestController
@RequestMapping(value="/products")
public class ProductController {
	
	@Autowired
	private ProductDetailsService productService;
	
	@RequestMapping(value="/productId/{product}", method=RequestMethod.GET)
	public ResponseEntity<List<Products>> login(@PathVariable("product") String productName) {
		
		List<Products> products = new ArrayList<Products>();
		try{
		products = productService.getProductDetails(productName);
		return new ResponseEntity<List<Products>>(products, HttpStatus.OK);
		}catch(ProductNotFoundException e){
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}catch(SQLException e){
			return new ResponseEntity<>(HttpStatus.SERVICE_UNAVAILABLE);
		}catch(Exception e){
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
	}

}
