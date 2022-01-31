package com.fdmgroup.ordersApiService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.fdmgroup.ordersApiService.model.Cart;

@Service("cartsApiClient2")
public class CartApiClientWebClient implements CartApiClient {

	private WebClient webClient;

	@Autowired
	public CartApiClientWebClient(WebClient webClient) {
		super();
		this.webClient = webClient;
	}

	@Override
	public List<Cart> getCarts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Cart getCart(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
