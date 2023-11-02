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

import com.Darshan.CategoryProductCMS.Dto.ValidateProduct;
import com.Darshan.CategoryProductCMS.Model.Product;
import com.Darshan.CategoryProductCMS.Service.ProductService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("")
	public List<Product> getAllProduct(@RequestParam(name = "page") int page){
		return service.getAllProduct(page);
	}
	
	@GetMapping("/{pid}")
	public Product getProductById(@PathVariable  long pid) {
		return service.getProductById(pid);
	}
	
	@PostMapping("")
	public Product addProduct(@RequestBody @Valid ValidateProduct product) {
		return service.addProduct(product);
	}
	
	@PutMapping("/{pid}")
	public Product updateProduct(@RequestBody  ValidateProduct product ,@PathVariable(name = "pid") long pid) {
		return service.updateProduct(product, pid);
	}
	
	@DeleteMapping("/{pid}")
	public String removeProduct(@PathVariable(name = "pid") long pid) {
		return service.removeProduct(pid);
	}
	

}
