package com.abc.ecom.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abc.ecom.entity.Category;
import com.abc.ecom.entity.Product;
import com.abc.ecom.service.CategoryService;
import com.abc.ecom.service.ProductService;

@RestController
public class CategoryController {
	
	@Autowired
	private CategoryService categoryService;
	
	@GetMapping("/category/all")
	public List<Category> fetchAllCategories(){
		List<Category> categories=categoryService.getAllCategories();
		return categories;
	}
	
	@GetMapping("/category/get/{categoryId}")
	public ResponseEntity<Object> fetchCategoryDetails(@PathVariable("categoryId") int categoryId) {
		ResponseEntity<Object> responseEntity;
		 Category category=categoryService.getCategory(categoryId);
		 responseEntity=new ResponseEntity<>(category,HttpStatus.OK);
		return responseEntity;
		
	}
	
	@PostMapping("/category/save")
	public ResponseEntity<Category> addCategory(@RequestBody Category category) {
		Category newCategory=categoryService.saveCategory(category);
		ResponseEntity<Category> responseEntity=new ResponseEntity<>(newCategory,HttpStatus.CREATED); 
		return responseEntity;
	}
	
	

}
