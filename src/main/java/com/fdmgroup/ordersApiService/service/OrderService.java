package com.fdmgroup.ordersApiService.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fdmgroup.ordersApiService.exception.OrderNotFoundException;
import com.fdmgroup.ordersApiService.model.Cart;
import com.fdmgroup.ordersApiService.model.Order;
import com.fdmgroup.ordersApiService.repository.OrderRepository;

@Service
public class OrderService {

	private OrderRepository orderRepo;
	
	@Autowired
	private CartApiClient cartApiClient;

	@Autowired
	public OrderService(OrderRepository orderRepo) {
		super();
		this.orderRepo = orderRepo;
	}
	
	public List<Order> readOrders() {
		return orderRepo.findAll();
	}
	
	public Order readOrderById(int id) {
		Optional<Order> optOrder = orderRepo.findById(id);
		if (!optOrder.isPresent()) {
			throw new OrderNotFoundException("Order not found for id " + id);
		}
		return optOrder.get();		
	}
	
	public List<Cart> readCarts() {
		return cartApiClient.getCarts();
	}
	
	public Cart readCartById(int cartId) {
		return cartApiClient.getCart(cartId);
	}
	
	public Order createOrder(Order order, int cartId) {
		Cart cart = readCartById(cartId);
		order.setCart(cart);
		return orderRepo.save(order);
	}
	
	

}
