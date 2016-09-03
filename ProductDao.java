package com.websystique.springsecurity.dao;

import java.util.List;

import com.websystique.springsecurity.model.Product;

public interface ProductDao {

	List<Product> findAllUsers();
	void Add(Product product);
	void Delete(Integer id);
	Product findById(int id);
	
}
