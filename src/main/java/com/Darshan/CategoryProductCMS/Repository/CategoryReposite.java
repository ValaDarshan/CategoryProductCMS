package com.Darshan.CategoryProductCMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Darshan.CategoryProductCMS.Model.Category;

public interface CategoryReposite extends JpaRepository<Category, Long>{
	
	public Category findById(long id);
	
}
