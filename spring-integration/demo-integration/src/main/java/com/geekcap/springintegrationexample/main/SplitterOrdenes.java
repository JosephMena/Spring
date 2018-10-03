package com.geekcap.springintegrationexample.main;

import org.apache.log4j.Logger;
import org.springframework.integration.splitter.AbstractMessageSplitter;
import org.springframework.messaging.Message;

import com.geekcap.springintegrationexample.main.domain.Order;

public class SplitterOrdenes extends AbstractMessageSplitter {

	private static final Logger log = Logger.getLogger(SplitterOrdenes.class);

	@Override
	protected Object splitMessage(Message<?> message) {
		log.debug("*** [OrderSplitter] splitting Order into it's constituent OrderItems : number of OrderItems: "
				+ ((Order) message.getPayload()).getOrderItems().size() + " ****");

		return ((Order) message.getPayload()).getOrderItems();
	}
}
