package com.Darshan.CategoryProductCMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Darshan.CategoryProductCMS.CustomException.ProductNotFoundException;
import com.Darshan.CategoryProductCMS.Dto.ValidateProduct;
import com.Darshan.CategoryProductCMS.Model.Product;
import com.Darshan.CategoryProductCMS.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {
	
	
	@Autowired
	private ProductRepository productRepo;

	@Override
	public List<Product> getAllProduct( int page) {
		
		int limit = 10;
		int offset = (page >= 1) ? (page-1)*10 : 0; 
		
		// TODO Auto-generated method stub
		return productRepo.findAllWithLimitAndOffset(limit , offset);
	}

	@Override
	public Product getProductById(long pid) {
		
		Product product = productRepo.findById(pid);
		
		if(product == null) {
			throw new ProductNotFoundException("Proudct not found with id:" + pid);
		}
		
		return product;
	}

	@Override
	public Product addProduct(ValidateProduct product) {
		// TODO Auto-generated method stub
		
		Product Newproduct = Product.build(0, product.getName(), product.getDescription(), product.getPrice(), product.getCategory());
		
		return productRepo.save(Newproduct);
	}

	@Override
	public Product updateProduct(ValidateProduct product, long pid) {
		// TODO Auto-generated method stub
		Product updatedProduct = Product.build(pid, product.getName(), product.getDescription(), product.getPrice(), product.getCategory()); 
		
		return productRepo.save(updatedProduct);
	}

	@Override
	public String removeProduct(long pid) {
		// TODO Auto-generated method stub
		
		Product product = productRepo.findById(pid);
		if(product == null) {
			throw new ProductNotFoundException("Proudct not found with id:" + pid);
		}
		
		productRepo.deleteById(pid);
		return "Product with id: "+pid+" is removed.";
	}

}
