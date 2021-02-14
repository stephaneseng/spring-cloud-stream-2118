package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.binder.BindingCreatedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;

import java.util.function.Consumer;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    public Consumer<String> consumer() {
        return System.out::println;
    }

    @Bean
    public ApplicationListener<BindingCreatedEvent> bindingCreatedEventListener() {
        return bindingCreatedEvent -> {
            throw new RuntimeException("Test");
        };
    }
}
