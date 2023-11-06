package com.Darshan.CategoryProductCMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Darshan.CategoryProductCMS.Model.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	public Product findById(long id);
}
