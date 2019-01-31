package com.hendaam.subject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VerbServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(VerbServiceApplication.class, args);
	}
}
