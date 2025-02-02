package com.productapp.service;

import java.util.List;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;

import exceptions.ProductNotFoundException;

public interface IproductService {
   
	//inbuilt methods 
	void addProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(int productId);
	List<Product> getAllProduct();
	Product getById(int productId);
	
	//querying methods
	
	//derived queries
	List<ProductDTO> getByBrand(String brand) throws ProductNotFoundException;
	List<ProductDTO> getByBrandNameContains(String brand, String productName) throws ProductNotFoundException;
	
	//custum queris
	List<ProductDTO> getByCategory(String Category) throws ProductNotFoundException;
	List<ProductDTO> getByBrandPriceLess(String brand, double price)throws ProductNotFoundException;
	
	//native queries
	List<ProductDTO> getByLesserPrice(double price)throws ProductNotFoundException;
	List<ProductDTO> getByCategoryName(String category, String productName)throws ProductNotFoundException;
	
	//named query
	List<ProductDTO> getProductByBrand(String brand)throws ProductNotFoundException;
	List<ProductDTO> getByProductPrice(double price, String productName)throws ProductNotFoundException;
	
}
