package com.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	public ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) {

//		Insert
//		Product product = productRepository.save(new Product(0, "Eraser", "Stationery", 5, 3));

//		Update
//		Product product = productRepository.save(new Product(2, "Eraser", "Stationery", 7, 3));

//		Delete

//		deleteById throws an Exception if id not found
//		productRepository.deleteById(22);

//		delete fails silently if id not found
//		productRepository.delete(new Product(2, null, null, 0, 0));

//		Fetch all rows
//		List<Product> products = (List<Product>) productRepository.findAll();
//		System.out.println(products);

	}

}