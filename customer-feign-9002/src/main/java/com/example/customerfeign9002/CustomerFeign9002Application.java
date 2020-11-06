package com.example.customerfeign9002;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author leejalen
 */
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
@EnableSwagger2
public class CustomerFeign9002Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerFeign9002Application.class, args);
	}

}
