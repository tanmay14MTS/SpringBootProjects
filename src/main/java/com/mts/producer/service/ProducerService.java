package com.mts.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

@Component
public class ProducerService {

	@Autowired
	private JmsTemplate jmsTemplate;
	
	@Value("${my.producer.destination-name}")
	private String destination;
	
	public boolean sendMessage(String message) {
		boolean status=false;
		try {
			MessageCreator messageCreator= (session)->{
				return session.createTextMessage(message);
			};
			
			jmsTemplate.send(destination, messageCreator);
			status=true;
		} catch (Exception e) {
			status=false;
			e.printStackTrace();
		}
		
		return status;
		
	}
}
