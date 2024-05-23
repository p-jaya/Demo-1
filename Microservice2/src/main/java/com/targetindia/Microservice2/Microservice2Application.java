package com.targetindia.Microservice2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Microservice2Application {

	private final KafkaTemplate<String, String> kafkaTemplate;

	public Microservice2Application(KafkaTemplate<String, String> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public static void main(String[] args) {
		SpringApplication.run(Microservice2Application.class, args);
	}

	@KafkaListener(topics = "initial-topic", groupId = "microservice2")
	public void consume(String message) {
		String modifiedMessage = message + ", how are you doing?";
		kafkaTemplate.send("modified-topic", modifiedMessage);
		System.out.println("Modified and sent message: " + modifiedMessage);
	}
}

