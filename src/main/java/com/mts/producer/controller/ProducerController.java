package com.mts.producer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mts.producer.service.ProducerService;

@RestController
@RequestMapping("/producer")
public class ProducerController {

	@Autowired
	private ProducerService service;
	
	@RequestMapping("/send/{message}")
	public String sendMessageToMOM(@PathVariable String message) {
		service.sendMessage(message);
		
		return "Message SENT";
		
		
	}
}
