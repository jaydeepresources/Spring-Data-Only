package com.boot.entity;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Integer> {

// 	Named Query using named parameters and index
// 			select * from product where product_name like 'Pen%';
//	@Query("select p from Product p where p.productName like ?1")
//	List<Product> findByProductNameLike(String productName);

//  Derived Query auto generated
	List<Product> findByProductNameLike(String productName);

//	Derived Query
	List<Product> findByProductRating(Integer productRating);

//	Pure SQL Native Query returning raw Object[][]
	@Query(value = "select avg(product_price), product_rating from product group by product_rating", nativeQuery = true)
	Object[][] groupProductsByRatings();

//	Pure SQL Native Query returning Projection
	@Query(value = "select avg(product_price) as averagePrice, product_rating as productRating from product group by product_rating", nativeQuery = true)
	List<ProjectionAveragePriceGroupedByRating> groupProductsByRatingsProjection();

//	Find product by name
	Product findByProductName(String productName);

}