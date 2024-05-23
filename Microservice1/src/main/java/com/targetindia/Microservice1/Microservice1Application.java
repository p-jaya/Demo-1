package com.targetindia.Microservice1;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Microservice1Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice1Application.class, args);
	}

	@Bean
	public CommandLineRunner sendMessage(KafkaTemplate<String, String> kafkaTemplate) {
		return args -> {
			kafkaTemplate.send("initial-topic", "Hello");
			System.out.println("Message sent: Hello");
		};
	}
}

