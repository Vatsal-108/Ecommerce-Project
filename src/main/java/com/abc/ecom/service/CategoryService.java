package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Category;

public interface CategoryService {

	public Category saveCategory(Category category);
	
	public Category getCategory(int categoryId);
	
	public List<Category> getAllCategories();
}

