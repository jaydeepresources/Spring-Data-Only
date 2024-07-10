package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

@SpringBootApplication
@Transactional
public class SpringBoot1Application implements CommandLineRunner {

	private static final Logger log = LoggerFactory.getLogger(SpringBoot1Application.class);

	@Autowired
	ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

// 		TODO:	Insert
//		Product product = new Product(0, "Greeting Card", "Gift", 350, 2);
//		Product demo = productRepository.save(product);
//		log.info("Product Saved.");
//		log.info(demo.toString());

// 		TODO:	Update
//		Product product = new Product(302, "Greeting Card", "Gift", 250, 2);
//		Product demo = productRepository.save(product);
//		log.info("Product Updated.");
//		log.info(demo.toString());
		
// 		TODO:	Delete
//		Integer res = productRepository.deleteByProductId(2);
//		if(res == 1)
//			log.info("1 Product Deleted.");
//		else
//			log.info("Product not found.");

// 		TODO:	View
//		List<Product> products = (List<Product>) productRepository.findAll();
//		for (Product product : products) {
//			log.info(product.toString());
//		}
		
// 		TODO:	Search by id
//		Optional<Product> opt = productRepository.findById(102);
//		if(opt.isEmpty()) {
//			log.info("Product not found.");
//			return;
//		}
//		Product product = opt.get();
//		log.info(product.toString());
		
// 		TODO:	Search by product rating		
//		List<Product> products = productRepository.findByProductRating(40);
//		for (Product product : products) {
//			log.info(product.toString());
//		}
		
// 		TODO:	Search by product name containing pen
//		List<Product> products = productRepository.findByProductNameContaining("p");
//		for (Product product : products) {
//			log.info(product.toString());
//		}

	}

}
