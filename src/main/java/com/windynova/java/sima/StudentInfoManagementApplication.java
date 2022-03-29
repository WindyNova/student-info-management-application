package com.windynova.java.sima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class StudentInfoManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentInfoManagementApplication.class, args);
	}

}
