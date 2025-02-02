package com.productapp.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.productapp.model.Product;
import com.productapp.model.ProductDTO;
import com.productapp.model.ProductMapper;
import com.productapp.repo.IproductServiceRepo;

import exceptions.ProductNotFoundException;

@Service
public class IproductServiceImpl implements IproductService {

	@Autowired
	IproductServiceRepo iproductServiceRepo;
	@Autowired
	ProductMapper mapper;
	
	@Override
	public void addProduct(Product product) {
		// TODO Auto-generated method stub
		iproductServiceRepo.save(product);

	}

	@Override
	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		//check if product is available. if so, update the product or else create a new row
		iproductServiceRepo.save(product);

	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		iproductServiceRepo.deleteById(productId);
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		return iproductServiceRepo.findAll();
	}

	@Override
	public Product getById(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> p =  iproductServiceRepo.findById(productId);
		if(p.isPresent()) return p.get();
		return null;
	}

	@Override
	public List<ProductDTO> getByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.getByBrand(brand);
		List<ProductDTO> productDTOs = products.stream()
				       .map(n->mapper.convertToDto(n))
				       .collect(Collectors.toList());
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product");
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getByBrandNameContains(String brand, String productName) {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.readByBrandAndProductNameContaining(brand, productName);
		List<ProductDTO> productDTOs = converter(products);
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product found");
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getByCategory(String Category) {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.getByCategory(Category);
		List<ProductDTO> productDTOs = converter(products);
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product found");
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getByLesserPrice(double price) {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.getByLesserPrice(price);
		List<ProductDTO> productDTOs = converter(products);
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product found");
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getProductByBrand(String brand) {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.getProductByBrand(brand);
		List<ProductDTO> productDTOs = converter(products);
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product found");
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getByProductPrice(double price, String productName) {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.getByCategoryPriceLess(price, productName);
		List<ProductDTO> productDTOs = converter(products);
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product found");
		return productDTOs;
	}
	
	private List<ProductDTO> converter(List<Product> products){
		List<ProductDTO> productDTOs = products.stream()
			       .map(n->mapper.convertToDto(n))
			       .collect(Collectors.toList());
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getByBrandPriceLess(String brand, double price) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.getByBrandPriceLess(brand, price);
		List<ProductDTO> productDTOs = converter(products);
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product found");
		return productDTOs;
	}

	@Override
	public List<ProductDTO> getByCategoryName(String category, String productName) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		List<Product> products = iproductServiceRepo.getByCategoryNameContains(category, "%"+productName+"%");
		List<ProductDTO> productDTOs = converter(products);
		if(productDTOs.isEmpty()) throw new ProductNotFoundException("no such product found");
		return productDTOs;
	}

}
