package com.bit.boot14;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class Boot14Application {

	public static void main(String[] args) {
		SpringApplication.run(Boot14Application.class, args);
	}

}
