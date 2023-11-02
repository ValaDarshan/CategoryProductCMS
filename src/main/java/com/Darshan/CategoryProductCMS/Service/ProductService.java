package com.Darshan.CategoryProductCMS.Service;

import java.util.List;

import com.Darshan.CategoryProductCMS.Dto.ValidateProduct;
import com.Darshan.CategoryProductCMS.Model.Product;

public interface ProductService {

	public List<Product> getAllProduct(int page);
	
	public Product getProductById(long pid) ;
	
	public Product addProduct(ValidateProduct product);
	
	public Product updateProduct(ValidateProduct product ,long pid) ;
	
	public String removeProduct(long pid); 
	
}
