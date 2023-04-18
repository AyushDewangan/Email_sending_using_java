package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
//public class OtimaUserApplication implements ApplicationRunner {
public class OtimaUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(OtimaUserApplication.class, args);
	}

//	@Autowired
//	private KafkaTemplate<String, String> kafkaTemplate;
//
//	public void sendMessage(String msg) {
//		kafkaTemplate.send("tutorialspoint", msg);
//	}
//
//	@KafkaListener(topics = "tutorialspoint", groupId = "group-id")
//	public void listen(String message) {
//		System.out.println("Received Messasge in group - group-id: " + message);
//
//	}
//
//	@Override
//	public void run(ApplicationArguments args) throws Exception {
//		sendMessage("Hi Welcome to Spring For Apache Kafka");
//	}

}
