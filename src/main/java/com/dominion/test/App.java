package com.dominion.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.dominion.test")
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}


