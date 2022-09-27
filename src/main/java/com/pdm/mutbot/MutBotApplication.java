package com.pdm.mutbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class MutBotApplication {

	public static void main(String[] args) {
		SpringApplication.run(MutBotApplication.class, args);
	}

}
