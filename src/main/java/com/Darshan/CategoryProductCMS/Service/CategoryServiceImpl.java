package com.Darshan.CategoryProductCMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Darshan.CategoryProductCMS.CustomException.CategoryNotFoundException;
import com.Darshan.CategoryProductCMS.Dto.ValidateCategory;
import com.Darshan.CategoryProductCMS.Model.Category;
import com.Darshan.CategoryProductCMS.Repository.CategoryReposite;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryReposite cateRepo;

	@Override
	public List<Category> getAllCategory(int page , int pageSize) {
		
		Pageable p = PageRequest.of(page, pageSize);
		return cateRepo.findAll(p).getContent();
	}

	@Override
	public Category getCategoryById(long cid) {
		Category categoty = cateRepo.findById(cid);
		if (categoty == null) {
			throw new CategoryNotFoundException("Category with "+ cid+" not found!!");
		}
		return categoty;
	}

	@Override
	public Category addCategory(ValidateCategory category) {
		Category NewCategory = Category.build(0, category.getName(), category.getDescription(), category.getProducts());
		return cateRepo.save(NewCategory);
	}

	@Override
	public Category updateCategory(ValidateCategory category, long cid) {
		Category getCategory = Category.build(cid, category.getName(), category.getDescription(), category.getProducts());
		return cateRepo.save(getCategory);
	}

	@Override
	public String removeCategory(long cid) {

		Category category = cateRepo.findById(cid);
		if (category == null) {
			throw new CategoryNotFoundException("Category with id "+ cid +" not found!!");
		}
		cateRepo.deleteById(cid);

		return "Category having id: " + cid + "removed !!..";
	}


}
