package com.productapp.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;

import exceptions.ProductNotFoundException;

@Repository
public interface IproductServiceRepo extends JpaRepository<Product, Integer>{

	List<Product> getByBrand(String brand);
	List<Product> readByBrandAndProductNameContaining(String brand, String productName);
	
	//custum queries
	//use jpql and method name can be anything while in native queries, proper naming convention is required
	@Query("from Product p where p.category = ?1")
	List<Product> getByCategory(String Category);
	@Query("from Product p where p.brand = ?1 and p.price <?2")
	List<Product> getByBrandPriceLess(String brand, double price);
	
	//native queries - regular sql queris, can be of any name
	@Query(value = "select * from product where cost <?1", nativeQuery = true)   
	List<Product> getByLesserPrice(double price);
	@Query(value = "select * from product where category = ?1 and product_name like ?2", nativeQuery = true)
	List<Product> getByCategoryNameContains(String category, String productName);
	
	//named query - can be of any name
	@Query(name = "getByBrand")
	List<Product> getProductByBrand(String brand);
	@Query(name = "getByProductPrice")
	List<Product> getByCategoryPriceLess(double price, String productName);

	
}
