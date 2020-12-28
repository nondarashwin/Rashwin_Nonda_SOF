package com.manipal.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	@KafkaListener(topics = "check1" , groupId = "anything")
	public void consume(String info)
	{
		System.out.println("im consumer 2");
		System.out.println("info Received:" +info);
	}
}
