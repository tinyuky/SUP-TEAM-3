package com.websystique.springsecurity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.websystique.springsecurity.dao.ProductDao;
import com.websystique.springsecurity.model.Product;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao dao;

	public List<Product> findAllUsers() {
		return dao.findAllUsers();
	}

	public void Add(Product product) {
		dao.Add(product);
	}

	public Product findById(int id) {
		return dao.findById(id);
	}

	public void Delete(int id) {
		dao.Delete(id);
	}

	public void updateProduct(Product product) {
		// TODO Auto-generated method stub
		Product entity = dao.findById(product.getId());
		if (entity != null) {
			// entity.setId(product.getId());
			entity.setTen(product.getTen());
			entity.setDiachi(product.getDiachi());
			entity.setSdt(product.getSdt());
			entity.setGia1(product.getGia1());
			entity.setGia2(product.getGia2());
			entity.setPr(product.getPr());
		}
	}

}
