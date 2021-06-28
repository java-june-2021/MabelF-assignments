package com.codingdojo.firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController // Allows to respond as controller
public class FirstprojectApplication { //Main entry point

	public static void main(String[] args) {
		SpringApplication.run(FirstprojectApplication.class, args);
	}

	
	@RequestMapping("/")
	public String hello() {
		return "Hello Client! How are you doing?";
	}
	
	@RequestMapping("/random")
	public String randomMessage() {
		return "Spring Boot is great! So easy to respond with strings";
	}
}
