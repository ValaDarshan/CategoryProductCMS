package com.Darshan.CategoryProductCMS.Service;

import java.util.List;

import com.Darshan.CategoryProductCMS.Dto.ValidateCategory;
import com.Darshan.CategoryProductCMS.Model.Category;

public interface CategoryService {
	
	public List<Category> getAllCategory(int page) ;
	
	public Category getCategoryById(long cid);
	
	public Category addCategory(ValidateCategory category);
	
	public Category updateCategory(ValidateCategory category,long cid);
	
	public String removeCategory(long cid); 

}
