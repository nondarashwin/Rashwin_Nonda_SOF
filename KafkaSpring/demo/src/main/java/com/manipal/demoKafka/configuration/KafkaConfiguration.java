package com.manipal.demoKafka.configuration;

import java.util.HashMap;
import java.util.Map;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
//import com.fasterxml.jackson.databind.ser.std.StringSerializer;

@Configuration
public class KafkaConfiguration
{
	@Bean
	public ProducerFactory<String,String> producerFactory()
	{
		Map<String, Object> configs = new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configs);
		return producerFactory;
	}
	
	@Bean
	public KafkaTemplate<String,String> kafkaTemplate()
	{
		return new KafkaTemplate<String,String>(producerFactory());
	}
}
	
	
	
	
	
	
	
	/*@Bean
		public ProducerFactory<String, String> producerFactory(){​​​​
				Map<String, Object> configs = new HashMap<>();
				configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
				configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
				configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
				ProducerFactory<String, String> producerFactory = new DefaultKafkaProducerFactory<>(configs);
				return producerFactory;
		}​​​​
		
		@Bean
		public KafkaTemplate<String, String> kafkaTemplate() 
		​​{
			return new KafkaTemplate<String, String>(producerFactory());
		​​​​}*/




