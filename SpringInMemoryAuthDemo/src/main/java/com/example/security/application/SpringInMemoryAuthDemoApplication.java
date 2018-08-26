package com.example.security.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages= {"com.example.security.controller","com.example.security.config"})
public class SpringInMemoryAuthDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringInMemoryAuthDemoApplication.class, args);
	}
}
