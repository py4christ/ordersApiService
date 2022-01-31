package com.fdmgroup.ordersApiService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fdmgroup.ordersApiService.model.Order;

public interface OrderRepository extends JpaRepository<Order, Integer> {


}
