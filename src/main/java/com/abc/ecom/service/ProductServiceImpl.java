package com.abc.ecom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.ecom.entity.Category;
import com.abc.ecom.entity.Product;
import com.abc.ecom.exception.ProductNotFoundException;
import com.abc.ecom.exception.ResourceNotFoundException;
import com.abc.ecom.repository.CategoryRepository;
import com.abc.ecom.repository.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	public Product saveProduct(int categoryId,Product product) {
		// TODO Auto-generated method stub
		Optional<Category> optionalCategory=categoryRepository.findById(categoryId);
		if(optionalCategory.isEmpty()) {
			throw new ResourceNotFoundException("Category not existing with given Id"+categoryId);
		}
		Category category=optionalCategory.get();
		product.setCategory(category);
		Product newProduct=productRepository.save(product);
		return newProduct;
	}

	@Override
	public Product getProductById(int productId) throws ProductNotFoundException {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct=productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product Not existing with Id:"+productId);
		}
		Product product=optionalProduct.get();
		return product;
	}

	@Override
	public List<Product> getAllProduct() {
		// TODO Auto-generated method stub
		List<Product> products=productRepository.findAll();
		return products;
	}

	@Override
	public Product updateProduct(Product product) {
		Optional<Product> optionalProduct=productRepository.findById(product.getProductId());
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product Not existing with Id:"+product.getProductId());
		}
		Product updatedProduct=productRepository.save(product);
		
		return updatedProduct;
	}

	@Override
	public void deleteProduct(int productId) {
		// TODO Auto-generated method stub
		Optional<Product> optionalProduct=productRepository.findById(productId);
		if(optionalProduct.isEmpty()) {
			throw new ProductNotFoundException("Product Not existing with Id:"+productId);
		}
		productRepository.deleteById(productId);
		
	}

	@Override
	public List<Product> getProductByCategory(String categoryName) {
		// TODO Auto-generated method stub
		List<Product> products=productRepository.findByCategory(categoryName);
		return products;
	}
	
	

}
