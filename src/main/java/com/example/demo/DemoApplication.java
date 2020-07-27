package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @SpringBootApplication is a composite application that combines three other
 * annotations:
 * @SpringBootConfiguration—Designates this class as a configuration class.
 * @EnableAutoConfiguration—Enables Spring Boot automatic configuration.
 * @ComponentScan—Enables component scanning.
 */
@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		/**
		 * The main() method calls a static run() method on the SpringApplication class,
		 * which performs the actual bootstrapping of the application, creating the Spring application
		 * context. The two parameters passed to the run() method are a configuration
		 * class and the command-line arguments.
		 */
		SpringApplication.run(DemoApplication.class, args);
	}

}
