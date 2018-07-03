package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer
@EnableEurekaClient
public class SpringCloudConfigServer7002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigServer7002Application.class, args);
	}
}
