package com.boot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.boot.entity.Product;
import com.boot.entity.ProductRepository;
import com.boot.entity.ProjectionAveragePriceGroupedByRating;
import com.boot.exceptions.ProductNotFoundException;

@RestController
public class ProductController {

	@Autowired
	ProductRepository productRepository;

	@ExceptionHandler(ProductNotFoundException.class)
	public ResponseEntity<String> handleEmployeeNotFoundException(ProductNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage() + "==EH==", HttpStatus.NOT_FOUND);
	}

	@GetMapping("/products")
	public List<Product> getProducts() {
		return (List<Product>) productRepository.findAll();
	}

	@GetMapping("/products/{productId}")
	public Product getProduct(@PathVariable int productId) {
		try {
			Optional<Product> optional = productRepository.findById(productId);
			if (optional.isPresent())
				return optional.get();

			throw new ProductNotFoundException("Product couldn't be found while searching.");

		} catch (Exception e) {
			throw new ProductNotFoundException("Product couldn't be found while searching.");
		}
	}

	@GetMapping("/products/find/{productName}")
	public List<Product> getProductsLike(@PathVariable String productName) {
		return (List<Product>) productRepository.findByProductNameLike(productName + "%");
	}

	@GetMapping("/products/stats/raw")
	public Object[][] getRatingStats() {
		return productRepository.groupProductsByRatings();
	}

	@GetMapping("/products/stats/projection")
	public List<ProjectionAveragePriceGroupedByRating> getRatingStatsProjection() {
		return productRepository.groupProductsByRatingsProjection();
	}

	@PostMapping("/products")
	public Product saveProduct(@RequestBody Product product) {

		return productRepository.save(product);
	}

	@DeleteMapping("/products/{productId}")
	public String deleteProduct(@PathVariable int productId) {
		try {
			productRepository.deleteById(productId);
			return "OK";
		} catch (Exception e) {
			throw new ProductNotFoundException("Product couldn't be found while deleting.");
		}

	}

}