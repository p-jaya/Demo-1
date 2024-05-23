package com.targetindia.Microservice3;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Microservice3Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice3Application.class, args);
	}

	@KafkaListener(topics = "modified-topic", groupId = "microservice3")
	public void consume(String message) {
		System.out.println("Final message received: " + message);
	}
}
