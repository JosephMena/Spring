package com.geekcap.springintegrationexample.main;

import java.util.List;

import org.apache.log4j.Logger;

import com.geekcap.springintegrationexample.main.domain.Order;
import com.geekcap.springintegrationexample.main.domain.OrderItem;

public class CompletadorVenta {

	private static final Logger log = Logger.getLogger(CompletadorVenta.class);

	public Order prepareDelivery(List<OrderItem> orderItems) {
		final Order order = new Order();
		order.setOrderItems(orderItems);
		
//		log.debug("*** [OrderCompleter] CompletedOrder : "
//		+ order +" ****");

		log.debug("*** [OrderCompleter] CompletedOrder Discounted cost: "
		+ order.getTotalDiscountedCost() +" ****");

		return order;
	}
	
}
