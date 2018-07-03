package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients//开启feign功能
public class SpringCloudFeignConsumer80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudFeignConsumer80Application.class, args);
	}
}
