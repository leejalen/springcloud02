package com.example.providerhystrix8004;

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

/**
 * @author leejalen
 */
@EnableHystrix
@EnableEurekaClient
@SpringBootApplication
public class ProviderHystrix8004Application {

	public static void main(String[] args) {
		SpringApplication.run(ProviderHystrix8004Application.class, args);
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

	/*@Bean
	public ServletRegistrationBean getServlet() {
		HystrixMetricsStreamServlet streamServlet = new HystrixMetricsStreamServlet();
		ServletRegistrationBean registrationBean = new ServletRegistrationBean(streamServlet);
		registrationBean.setLoadOnStartup(1);
		registrationBean.addUrlMappings("/actuator/hystrix.stream");
		registrationBean.setName("HystrixMetricsStreamServlet");
		return registrationBean;
	}*/
}
