package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
@EnableHystrixDashboard//启用Hystrix Dashboard
public class SpringCloudRibbonHystrixDashboardConsumer80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudRibbonHystrixDashboardConsumer80Application.class, args);
	}
}
