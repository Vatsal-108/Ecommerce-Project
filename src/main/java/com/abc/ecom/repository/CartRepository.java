package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.Cart;

public interface CartRepository extends JpaRepository<Cart,Integer>{

}
