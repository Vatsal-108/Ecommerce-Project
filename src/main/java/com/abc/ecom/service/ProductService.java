package com.abc.ecom.service;

import java.util.List;

import com.abc.ecom.entity.Product;



public interface ProductService  {
	public Product saveProduct(int categoryId,Product product);
	
	public Product getProductById(int productId);
	
	public List<Product> getAllProduct();

	public Product updateProduct(Product product);
	
	public void deleteProduct(int productId);
	
	public List<Product> getProductByCategory(String categoryName);

}
