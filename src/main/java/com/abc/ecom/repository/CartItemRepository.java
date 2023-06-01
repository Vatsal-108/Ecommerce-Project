package com.abc.ecom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abc.ecom.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem,Integer> {

}
