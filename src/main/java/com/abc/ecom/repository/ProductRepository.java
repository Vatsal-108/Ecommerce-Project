package com.abc.ecom.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Integer>{

	public List<Product> findByCategory(String categoryName);
}
