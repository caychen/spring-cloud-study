package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringCloudZuulHystrixGateway80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulHystrixGateway80Application.class, args);
	}
}
