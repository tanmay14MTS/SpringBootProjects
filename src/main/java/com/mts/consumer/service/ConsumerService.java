package com.mts.consumer.service;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerService {

	@JmsListener(destination = "${my.producer.destination-name}")
	public void readMessage(String message) {
		
		try {
			System.out.println("Message recieved");
			System.out.println(message);
			
		} catch (Exception e) {

			e.printStackTrace();
		}
		
	}
	
}
