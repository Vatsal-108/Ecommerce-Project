package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Category;

public interface CategoryRepository extends JpaRepository<Category,Integer> {

}
