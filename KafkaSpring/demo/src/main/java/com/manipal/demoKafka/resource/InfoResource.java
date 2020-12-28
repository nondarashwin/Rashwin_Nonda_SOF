package com.manipal.demoKafka.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoResource {
	
	@Autowired
	private KafkaTemplate<String , String> kafkaTemplate;
	
	private String topicInfo = "info_topic";
	
	@GetMapping("/info/{info}")
	public String publish(@PathVariable String info)
	{

		 kafkaTemplate.send(topicInfo,info);
		 return "Information";
	}

}
