package com.hendaam.sentence.robbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SentenceServiceRobbinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SentenceServiceRobbinApplication.class, args);
	}
}
