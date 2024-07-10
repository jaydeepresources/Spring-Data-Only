package com.example.demo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	Integer deleteByProductId(Integer productId);
	List<Product> findByProductRating(Integer productRating);
	List<Product> findByProductNameContaining(String productName);
	
	
}