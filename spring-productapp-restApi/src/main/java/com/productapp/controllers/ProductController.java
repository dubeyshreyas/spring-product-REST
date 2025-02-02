package com.productapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;
import com.productapp.service.IproductService;

import exceptions.ProductNotFoundException;

@RestController
@RequestMapping("/product-api/v1")
public class ProductController {
	
	@Autowired
	private IproductService productService;

	@PostMapping("/products")
	void addProduct(@RequestBody Product product){
		productService.addProduct(product);
	}
	
	@PutMapping("/products")
	void updateProduct(@RequestBody Product product){
	   productService.updateProduct(product);
	}
	
	@DeleteMapping("/products/id/{id}")
	void deleteProduct(@PathVariable("id")int productId){
		productService.deleteProduct(productId);
	}
	
	@GetMapping("/products")
	List<Product> getAllProduct(){
	 return	productService.getAllProduct();
	}
	
	@GetMapping("/products/id/{id}")
	Product getById(@PathVariable("id") int productId){
		return productService.getById(productId);
	}
	
	//querying methods
	//derived queries
	@GetMapping("/products/brand/{brand}")
	List<ProductDTO> getByBrand(@PathVariable("brand")String brand){
		return productService.getByBrand(brand);
	}
	@GetMapping("/products/brand/{brand}/product-name/{productname}")
	List<ProductDTO> getByBrandNameContains(@PathVariable String brand,@PathVariable("productname") String productName){
		return productService.getByBrandNameContains(brand, productName);
	}
	
	//custum queris
	@GetMapping("/products/category")
	List<ProductDTO> getByCategory(@RequestParam("category") String Category){
		return productService.getByCategory(Category);
	}
	@GetMapping("/products/brand/price")
	List<ProductDTO> getByBrandPriceLess(@RequestParam String brand, @RequestParam double price){
		return productService.getByBrandPriceLess(brand, price);
	}
	
	//native queries
	@GetMapping("/products/price/{price}")
	List<ProductDTO> getByLesserPrice(@PathVariable double price){
		return productService.getByLesserPrice(price);
	}
	@GetMapping("/products/category/{category}/product-name/{name}")
	List<ProductDTO> getByCategoryName(@PathVariable("category") String category,@PathVariable("name") String productName){
		return productService.getByCategoryName(category, productName);
	}
	
	//named query
	@GetMapping("/products/product-brand/{brand}")
	List<ProductDTO> getProductByBrand(@PathVariable("brand") String brand){
		return productService.getProductByBrand(brand);
	}
	@GetMapping("/products/price/{price}/p-name/{product}")
	List<ProductDTO> getByProductPrice(@PathVariable("price") double price,@PathVariable("product") String productName){
		return productService.getByProductPrice(price, productName);
	}
}
