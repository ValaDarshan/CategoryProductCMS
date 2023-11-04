package com.Darshan.CategoryProductCMS.Dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ValidateProduct {
	
	@NotBlank(message = "Product name required")
	private String name;
	@Size(max = 200, message = "Description length 200 character")
	private String description;
	
	@Min(value = 1 , message = "Product price should be greater than 1")
	private long price;
	private long category_id;
	
	
	

}
