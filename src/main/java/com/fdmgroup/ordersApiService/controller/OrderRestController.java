package com.fdmgroup.ordersApiService.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.fdmgroup.ordersApiService.model.Cart;
import com.fdmgroup.ordersApiService.model.Order;
import com.fdmgroup.ordersApiService.service.OrderService;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderRestController {
	
	private OrderService orderService;

	@Autowired
	public OrderRestController(OrderService orderService) {
		super();
		this.orderService = orderService;
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Order>> getOrders() {
		return ResponseEntity.ok(orderService.readOrders());
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity getOrdeById(@PathVariable int orderId) {
		return ResponseEntity.ok(orderService.readOrderById(orderId));
	} 
	
	@PostMapping("/{cartId}")
	public ResponseEntity<Order> createOrder(@RequestBody Order order, @PathVariable int cartId) {
		Order createdOrder = orderService.createOrder(order, cartId);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(order.getId())
				.toUri();
	//	return ResponseEntity.created(location).build();
		return ResponseEntity.created(location).body(createdOrder);
	}
	
	@GetMapping("/carts")
	public ResponseEntity<List<Cart>> getProducts() {
		return ResponseEntity.ok(orderService.readCarts());
	}
	
	@GetMapping("/carts/{cartId}")
	public ResponseEntity getCartById(@PathVariable int cartId) {
		return ResponseEntity.ok(orderService.readCartById(cartId));
	}
	
	
	
	

}
