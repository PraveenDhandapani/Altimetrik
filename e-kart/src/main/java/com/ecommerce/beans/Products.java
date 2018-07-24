package com.ecommerce.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection="product_details")
public class Products {
	
	@Id
	@JsonProperty("productId")
	private String productId;
	
	@JsonProperty("productName")
	private String productName;
	
	@JsonProperty("description")
	private String description;
	
	@JsonProperty("brand")
	private String brand;
	
	@JsonProperty("mrp")
	private double mrp;
	
	@JsonProperty("discount")
	private double discount;
	
	@JsonProperty("isAvailable")
	private boolean isAvailable;
	
	@JsonProperty("rating")
	private double rating;

	
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMrp() {
		return mrp;
	}

	public void setMrp(double mrp) {
		this.mrp = mrp;
	}

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
	
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}
	
	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	

}
