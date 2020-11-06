package com.example.customerfeign9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author leejalen
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class CustomerFeign9002Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerFeign9002Application.class, args);
	}

}
