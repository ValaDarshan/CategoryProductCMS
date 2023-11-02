package com.Darshan.CategoryProductCMS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.Darshan.CategoryProductCMS.Model.Category;

public interface CategoryReposite extends JpaRepository<Category, Long>{
	
	public Category findById(long id);
	
	 	@Query(value = "SELECT * FROM Category LIMIT ?1 OFFSET ?2", nativeQuery = true)
	    List<Category> findAllWithLimitAndOffset(int limit, int offset);
}
