package com.Darshan.CategoryProductCMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Darshan.CategoryProductCMS.Dto.ValidateCategory;
import com.Darshan.CategoryProductCMS.Model.Category;
import com.Darshan.CategoryProductCMS.Service.CategoryService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	
		@Autowired
		private CategoryService service;
	
		@GetMapping("")
		public List<Category> getAllCategory(@RequestParam(name = "page" , defaultValue = "0" , required = false) int page , @RequestParam(name = "pageSize" , defaultValue = "10" , required = false) int pageSize) {
			return service.getAllCategory(page , pageSize);
		}
		
		@GetMapping("/{cid}")
		public Category getCategoryById(@PathVariable(name ="cid")  long cid) {
			return service.getCategoryById(cid);
		}
		
		@PostMapping("")
		public Category addCategory(@RequestBody @Valid ValidateCategory category) {
			return service.addCategory(category);
		}
		
		@PutMapping("/{cid}")
		public Category updateCategory(@RequestBody @Valid ValidateCategory category,@PathVariable(name = "cid") long cid) {
			return service.updateCategory(category, cid);
		}
		
		@DeleteMapping("/{cid}")
		public String removeCategory(@PathVariable(name = "cid") long cid) {
			return service.removeCategory(cid);
		}
}
