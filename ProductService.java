package com.websystique.springsecurity.service;

import java.util.List;
import com.websystique.springsecurity.model.Product;

public interface ProductService {
	
	Product findById(int id);
	List<Product> findAllUsers(); 
	void Add(Product product);
	void Delete(int id);
	void updateProduct(Product product);
}
