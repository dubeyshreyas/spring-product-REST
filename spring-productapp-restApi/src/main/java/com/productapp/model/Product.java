package com.productapp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQuery;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@NamedQuery(name = "getByBrand",query = "from Product p where p.brand = ?1")
@NamedQuery(name = "getByProductPrice", query = "from Product p where p.price <?1 and p.productName = ?2")
public class Product {

	
	public Product(String productName, String brand, String category, double price) {
		super();
		this.productName = productName;
		this.brand = brand;
		this.category = category;
		this.price = price;
	}
	private String productName;
	@Id
	@GeneratedValue
	private Integer productId;
	private String brand;
	private String category;
	@Column(name = "cost")
	private double price;
}
