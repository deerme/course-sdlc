package com.maxim.jms.producer.sender;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.JmsException;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class MessageSender {
	private static Logger logger = LogManager.getLogger(MessageSender.class.getName());
	@Autowired
	JmsTemplate jmsTemplate;
	
	public void send(String json) {
		try{
			jmsTemplate.convertAndSend(json);
			logger.info("Message Sent");
		}
		catch(JmsException jmsException)
		{
			logger.error("Message: " + json);
		}
		
	}
}
