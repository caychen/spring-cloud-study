package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker//注解开启断路器功能
public class SpringCloudRibbonHystrixConsumer80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonHystrixConsumer80Application.class, args);
	}
}
