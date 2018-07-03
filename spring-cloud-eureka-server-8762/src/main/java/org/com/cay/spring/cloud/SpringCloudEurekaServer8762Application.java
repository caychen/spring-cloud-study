package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringCloudEurekaServer8762Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServer8762Application.class, args);
	}
}
