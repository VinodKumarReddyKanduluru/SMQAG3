package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = ("com.example.controllers"))
@EntityScan(basePackages = "com.example.model")  // Add this line
@EnableJpaRepositories(basePackages = "com.example.repository")
@ComponentScan(basePackages = {"com.example.service", "com.example.controllers", /* add other packages if necessary */})

class DemoApplicationTests {

	@Test
	void contextLoads() {
	}

}
