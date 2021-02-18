package com.example.eurekaserver7004;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author leejalen
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServer7004Application {

	public static void main(String[] args) {
		SpringApplication.run(EurekaServer7004Application.class, args);
	}

}
