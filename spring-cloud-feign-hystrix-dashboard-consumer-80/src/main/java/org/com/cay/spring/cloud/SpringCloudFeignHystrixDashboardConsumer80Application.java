package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients

//要实现仪表盘监控，必须加入以下两个注解
@EnableHystrixDashboard
@EnableCircuitBreaker
public class SpringCloudFeignHystrixDashboardConsumer80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignHystrixDashboardConsumer80Application.class, args);
	}
}
