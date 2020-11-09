package com.example.zuul6001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @author leejalen
 */
@EnableZuulProxy
@SpringBootApplication
public class Zuul6001Application {

	public static void main(String[] args) {
		SpringApplication.run(Zuul6001Application.class, args);
	}

}
