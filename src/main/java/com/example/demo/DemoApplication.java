package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.Input;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.handler.annotation.Payload;

@SpringBootApplication
@EnableBinding(DemoApplication.Source.class)
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	interface Source {
		@Input("myChannel")
		MessageChannel input();
	}

	@StreamListener("myChannel")
	protected void consumer(@Payload String message) {
		System.out.println(message);
	}
}
