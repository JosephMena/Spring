package com.geekcap.springintegrationexample.main;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.geekcap.springintegrationexample.main.domain.Book;
import com.geekcap.springintegrationexample.main.domain.MusicCD;
import com.geekcap.springintegrationexample.main.domain.Order;
import com.geekcap.springintegrationexample.main.domain.OrderItem;
import com.geekcap.springintegrationexample.main.domain.Software;

public class VentaEnLinea {

	private static final Logger log = Logger.getLogger(VentaEnLinea.class);

	public static void main(String[] args) {

		// Get hold of spring context
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("/META-INF/app.xml",VentaEnLinea.class);

		// Inject in Shop instance (Gateway)
		Venta shop = (Venta) context.getBean("appVenta");

		final Order order = createOrder();

		log.debug("*** [VentaEnLinea] ****");
		shop.placeOrder(order);

		context.close();
	}
	
	private static Order createOrder() {
		Book book = new Book("Of Mice & Men", "Bluebird", new BigDecimal("100"), 1988, "John Steinbeck");
		MusicCD cd = new MusicCD("Off the Wall", "publisher", new BigDecimal("100"), 1975, "Michael Jackson");
		Software macos = new Software("Mavericks", "publisher", new BigDecimal("100"), 2014, "10.9.3");
		
		OrderItem bookItems = new OrderItem(book);
//		bookItems.incrementQuantity();
		
		OrderItem cdItems = new OrderItem(cd);
//		cdItems.incrementQuantity();
//		cdItems.incrementQuantity();
		
		OrderItem swItems = new OrderItem(macos);
		
		final List<OrderItem> orderItems = new ArrayList<OrderItem>();
		orderItems.add(bookItems);
		orderItems.add(cdItems);
		orderItems.add(swItems);
		
		Order order = new Order();
		order.setOrderItems(orderItems);
		log.debug("Order: " + order);
//		log.debug("Total : "+ order.getTotalCost());

		return order;
	}

}
