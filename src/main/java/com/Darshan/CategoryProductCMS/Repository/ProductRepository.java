package com.Darshan.CategoryProductCMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Darshan.CategoryProductCMS.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findById(long id);
	
	 @Query(value = "SELECT pid,name,description, price ,category_id  FROM Product LIMIT ?1 OFFSET ?2", nativeQuery = true)
	  List<Product> findAllWithLimitAndOffset(int limit, int offset);
}
