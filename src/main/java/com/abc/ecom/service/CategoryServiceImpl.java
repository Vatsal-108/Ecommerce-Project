package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Category;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public Category saveCategory(Category category) {
		// TODO Auto-generated method stub
		Category newCategory=categoryRepository.save(category);
		return newCategory;
	}

	@Override
	public Category getCategory(int categoryId) {
		// TODO Auto-generated method stub
		Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new ResourceNotFoundException("Category not existing with id:"+categoryId);	
		}
		Category category=optionalCategory.get();
		return category;
	}

	@Override
	public List<Category> getAllCategories() {
		// TODO Auto-generated method stub
		List<Category> categories=categoryRepository.findAll();
		return categories;
	}

}
