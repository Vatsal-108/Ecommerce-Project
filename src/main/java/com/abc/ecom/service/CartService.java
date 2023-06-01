package com.abc.ecom.service;

import com.abc.ecom.entity.Cart;

public interface CartService {
	
	public Cart saveItemToCart(int cartId, int productId, int quantity);
}
