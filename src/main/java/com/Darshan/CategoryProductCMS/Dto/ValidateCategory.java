package com.Darshan.CategoryProductCMS.Dto;

import java.util.Set;

import com.Darshan.CategoryProductCMS.Model.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class ValidateCategory {
	
	@NotBlank(message = "Category name required")
	
	private String name;
	@Size(min = 0, max = 200, message = "Description length should be maximum 200 character")
	private String description;
	private Set<Product> products;

}
