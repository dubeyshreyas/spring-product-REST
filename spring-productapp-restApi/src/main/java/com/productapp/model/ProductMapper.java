package com.productapp.model;

import org.springframework.stereotype.Component;

@Component
public class ProductMapper {

	public ProductDTO convertToDto(Product product) {
		ProductDTO prod = new ProductDTO();
		String name = product.getProductName();
		String brand = product.getBrand();
		prod.setBrand(brand);
		prod.setProductName(name);
		prod.setCategory(product.getCategory());
		prod.setProductId(product.getProductId());
		prod.setPrice(product.getPrice());
		
		return prod;
	}
	
	public Product convertToProduct(ProductDTO dto){
		Product product = new Product();
		product.setBrand(dto.getBrand());
		product.setCategory(dto.getCategory());
		product.setPrice(dto.getPrice());
		product.setProductId(dto.getProductId());
		product.setProductName(product.getProductName());
		
		return product;
	}
}
