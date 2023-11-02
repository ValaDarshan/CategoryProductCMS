package com.Darshan.CategoryProductCMS.CustomException;

import java.util.HashMap;
import java.util.Map;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobleExceptionHandler {
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public Map<String , String> methodNotValidArgException(MethodArgumentNotValidException ex){
		HashMap<String , String> errors = new HashMap<>();
		
		ex.getBindingResult().getFieldErrors().forEach(er -> errors.put(er.getField(), er.getDefaultMessage()));
		
		return errors;
	}
	
	@ExceptionHandler(CategoryNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String categoryNotFoundException(CategoryNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(ProductNotFoundException.class)
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	public String ProductNotFoundException(ProductNotFoundException ex) {
		return ex.getMessage();
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String duplicateCategoryFoundExist(DataIntegrityViolationException ex) {
		return "Category already exist!!";
	}
	
	@ExceptionHandler(Exception.class)
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public String duplicateCategoryFoundExist(Exception ex) {
		return "Something went wrong!! "+ ex.getMessage();
	}
	
	
}
