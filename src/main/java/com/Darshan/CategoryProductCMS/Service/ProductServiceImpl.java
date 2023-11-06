package com.Darshan.CategoryProductCMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.Darshan.CategoryProductCMS.CustomException.CategoryNotFoundException;
import com.Darshan.CategoryProductCMS.CustomException.ProductNotFoundException;
import com.Darshan.CategoryProductCMS.Dto.ValidateProduct;
import com.Darshan.CategoryProductCMS.Model.Category;
import com.Darshan.CategoryProductCMS.Model.Product;
import com.Darshan.CategoryProductCMS.Repository.CategoryReposite;
import com.Darshan.CategoryProductCMS.Repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryReposite cateRepo;

	@Override
	public List<Product> getAllProduct(int page , int pageSize) {
		
		Pageable p = PageRequest.of(page, pageSize);
		Page<Product> getProducts= productRepo.findAll(p);
		List<Product> pro = getProducts.getContent();
		
		return pro;
	}

	@Override
	public Product getProductById(long pid) {

		Product product = productRepo.findById(pid);

		if (product == null) {
			throw new ProductNotFoundException("Proudct not found with id:" + pid);
		}

		return product;
	}

	@Override
	public Product addProduct(ValidateProduct product) {

		
		Category c = cateRepo.findById(product.getCategory_id());
		
		if(c == null) {
			throw new CategoryNotFoundException("Category does not exist");
		}
		
		Product Newproduct = Product.build(0, product.getName(), product.getDescription(), product.getPrice(), c);
		
		return productRepo.save(Newproduct);
	}

	@Override
	public Product updateProduct(ValidateProduct product, long pid) {
		// TODO Auto-generated method stub
		
		Category c = cateRepo.findById(product.getCategory_id());
		
		if(c == null) {
			throw new CategoryNotFoundException("Category does not exist");
		}
		Product updatedProduct = Product.build(pid, product.getName(), product.getDescription(), product.getPrice(),
				c);

		return productRepo.save(updatedProduct);
	}

	@Override
	public String removeProduct(long pid) {
		// TODO Auto-generated method stub

		Product product = productRepo.findById(pid);
		if (product == null) {
			throw new ProductNotFoundException("Proudct not found with id:" + pid);
		}

		productRepo.deleteById(pid);
		return "Product with id: " + pid + " is removed.";
	}

}
