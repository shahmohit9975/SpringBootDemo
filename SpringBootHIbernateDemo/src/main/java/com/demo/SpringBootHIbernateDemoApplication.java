package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
public class SpringBootHIbernateDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootHIbernateDemoApplication.class, args);
	}

}
