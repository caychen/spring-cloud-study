package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigClientBusAmqp6002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClientBusAmqp6002Application.class, args);
	}
}
