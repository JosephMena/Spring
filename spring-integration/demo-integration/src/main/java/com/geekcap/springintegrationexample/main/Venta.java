package com.geekcap.springintegrationexample.main;

import org.springframework.integration.annotation.Gateway;

import com.geekcap.springintegrationexample.main.domain.Order;

public interface Venta {

	
	@Gateway(requestChannel="ordersChannel")
	void placeOrder(Order order);
}
