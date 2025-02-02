package com.productapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ProductDTO {

	private String ProductName;
	private Integer productId;
	private String brand;
	private String category;
	private double price;
	
	public ProductDTO(String productName, String brand, String category, double price) {
		super();
		ProductName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
}
