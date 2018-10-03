package com.geekcap.springintegrationexample.main;

import org.apache.log4j.Logger;

import com.geekcap.springintegrationexample.main.domain.Book;
import com.geekcap.springintegrationexample.main.domain.MusicCD;
import com.geekcap.springintegrationexample.main.domain.OrderItem;
import com.geekcap.springintegrationexample.main.domain.Software;

public class RouterOrden {

	private static final Logger log = Logger.getLogger(RouterOrden.class);

	public String routeOrder(OrderItem orderItem) {
		
		log.debug("*** [OrderItemRouter] ****");

		String channel = "";
		if(isBook(orderItem)) {
			System.out.println("is book");
			channel = "bookItemsChannel";
		}
		else if(isMusic(orderItem)) {
			System.out.println("is Music");
			channel = "musicItemsChannel";
		}
		else if(isSoftware(orderItem)) {
			System.out.println("is Soft");
			channel = "softwareItemsChannel";
		}

		log.debug("*** [OrderItemRouter] sending item : " + orderItem.getItem().getTitle() + " to "+ channel +  " ****");

		return channel;
   }
	
	private Boolean isBook(OrderItem orderItem) {
		return orderItem.getItem() instanceof Book;			
	}
	private Boolean isMusic(OrderItem orderItem) {
		return orderItem.getItem() instanceof MusicCD;			
	}
	private Boolean isSoftware(OrderItem orderItem) {
		return orderItem.getItem() instanceof Software;			
	}
	
}
