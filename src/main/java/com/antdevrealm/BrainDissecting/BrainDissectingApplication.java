package com.antdevrealm.BrainDissecting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BrainDissectingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BrainDissectingApplication.class, args);
	}

}
