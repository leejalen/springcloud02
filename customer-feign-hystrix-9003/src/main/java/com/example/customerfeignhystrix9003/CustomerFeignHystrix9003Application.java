package com.example.customerfeignhystrix9003;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author leejalen
 */
@EnableSwagger2
@EnableFeignClients
@EnableEurekaClient
@EnableHystrixDashboard
@SpringBootApplication
public class CustomerFeignHystrix9003Application {

	public static void main(String[] args) {
		SpringApplication.run(CustomerFeignHystrix9003Application.class, args);
	}

	/**
	 * 如果要让hystrix监控器监控到当前应用，必须在启动类中加入此方法，hystrix监控器依赖只需加入到需要启动监控页面的应用里面
	 * */
	@Bean
	public ServletRegistrationBean hystrixMetricsStreamServlet() {
		ServletRegistrationBean registration = new ServletRegistrationBean(new HystrixMetricsStreamServlet());
		registration.addUrlMappings("/actuator/hystrix.stream");
		return registration;
	}

}
