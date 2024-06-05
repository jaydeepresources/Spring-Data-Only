package com.boot;

import java.util.ArrayList;
import java.util.List;

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
//		Product product = productRepository.save(new Product(0, "Pencils", "Stationery", 122, 4));

//		Update
//		Product product = productRepository.save(new Product(2, "Eraser", "Stationery", 7, 3));

//		Delete

//		deleteById throws an Exception if id not found
//		productRepository.deleteById(6);

//		delete fails silently if id not found
//		productRepository.delete(new Product(2, null, null, 0, 0));

//		Fetch all rows
//		List<Product> products = (List<Product>) productRepository.findAll();
//		System.out.println(products);

//		Fetch all products like pen
//		List<Product> products = (List<Product>) productRepository.findByProductNameLike("Pen%");
//		System.out.println(products);		

//		Fetch all products by rating
//		List<Product> products = (List<Product>) productRepository.findByProductRating(4);
//		System.out.println(products);

//		Fetch products by average price and group by rating - raw data

//		Object[][] products = productRepository.groupProductsByRatings();
//
//		for (int i = 0; i < products.length; i++) {
//			System.out.println("Average Price: " + products[i][0] + "\t" + "Rating: " + products[i][1]);
//		}

//		Fetch products by average price and group by rating - projection data

		List<ProjectionAveragePriceGroupedByRating> products = productRepository.groupProductsByRatings();

//		Display raw information Wrapped in a Proxy of Projection Interface

		for (ProjectionAveragePriceGroupedByRating p : products) {
			System.out.println("Average Price: " + p.getAveragePrice() + "\t" + "Rating: " + p.getProductRating());
		}

//		Wrap Projection Interface data into an actual class 

		List<PriceRatingStats> priceRatingProducts = new ArrayList<>();
		for (ProjectionAveragePriceGroupedByRating p : products) {
			priceRatingProducts.add(new PriceRatingStats(p.getAveragePrice(), p.getProductRating()));
		}

		System.out.println(priceRatingProducts);

	}

}