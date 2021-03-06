package com.example.provider8002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @author leejalen
 */
@SpringBootApplication
@EnableEurekaClient
public class Provider8002Application {

	public static void main(String[] args) {
		SpringApplication.run(Provider8002Application.class, args);
	}

}
