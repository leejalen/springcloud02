package com.example.providerhystrix8004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

/**
 * @author leejalen
 */
@SpringBootApplication
@EnableCircuitBreaker
public class ProviderHystrix8004Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderHystrix8004Application.class, args);
	}

}
