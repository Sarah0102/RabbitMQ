package com.example.workqueue;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WorkqueueApplication {

	public static void main(String[] args) {
		SpringApplication.run(WorkqueueApplication.class, args);
	}

}
