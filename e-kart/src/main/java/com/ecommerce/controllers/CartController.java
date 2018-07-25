package com.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ecommerce.beans.Cart;
import com.ecommerce.service.CartService;

@RestController
@RequestMapping(value="/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/getDetails/{userId}",method=RequestMethod.GET)
	public ResponseEntity<List<Cart>> getCartDetails(@PathVariable("userId") String userId){
		
		return new ResponseEntity<List<Cart>>(cartService.getCartDetails(userId),HttpStatus.OK);
	}
	
	@RequestMapping(value="/addToCart",method=RequestMethod.POST)
	public ResponseEntity<String> addToCart(@RequestBody List<Cart> cart){
		
		return new ResponseEntity<>(cartService.addToCart(cart),HttpStatus.CREATED);
	}

}
