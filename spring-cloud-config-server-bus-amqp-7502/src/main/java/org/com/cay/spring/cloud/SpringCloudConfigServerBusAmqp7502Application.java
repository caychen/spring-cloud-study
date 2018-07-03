package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class SpringCloudConfigServerBusAmqp7502Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServerBusAmqp7502Application.class, args);
	}
}
