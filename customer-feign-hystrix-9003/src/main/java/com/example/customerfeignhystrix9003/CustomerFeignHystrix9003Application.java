package com.example.customerfeignhystrix9003;

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
public class CustomerFeignHystrix9003Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerFeignHystrix9003Application.class, args);
	}

}
