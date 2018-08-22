package com.example.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.springboot")
@SpringBootApplication
public class AppSpringBootContactoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppSpringBootContactoApplication.class, args);
	}
}
