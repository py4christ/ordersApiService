package com.fdmgroup.ordersApiService.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fdmgroup.ordersApiService.model.Cart;

@Service("cartsApiClient1")
@Primary
public class CartApiClientRestTemplate implements CartApiClient {

	private RestTemplate restTemplate;
	
	@Autowired
	public CartApiClientRestTemplate(RestTemplate restTemplate) {
		super();
		this.restTemplate = restTemplate;
	}

	@Override
	public List<Cart> getCarts() {
		Cart[] carts = restTemplate.getForEntity("/api/v1/carts", Cart[].class).getBody();
		return Arrays.asList(carts);
	}

	@Override
	public Cart getCart(int cartId) {
		return restTemplate.getForEntity("/api/v1/carts/" + cartId, Cart.class).getBody();
	}
	
	

}
