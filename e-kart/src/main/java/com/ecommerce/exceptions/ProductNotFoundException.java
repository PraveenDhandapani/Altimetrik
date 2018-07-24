package com.ecommerce.exceptions;

public class ProductNotFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1723939301155393217L;

	public ProductNotFoundException(String msg){
		
		super(msg);
	}

}
