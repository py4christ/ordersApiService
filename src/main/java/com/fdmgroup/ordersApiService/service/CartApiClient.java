package com.fdmgroup.ordersApiService.service;

import java.util.List;

import com.fdmgroup.ordersApiService.model.Cart;

public interface CartApiClient {
	
	List<Cart> getCarts();

	Cart getCart(int id);

}
