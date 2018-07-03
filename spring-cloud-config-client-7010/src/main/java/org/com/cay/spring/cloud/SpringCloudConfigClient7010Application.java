package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudConfigClient7010Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudConfigClient7010Application.class, args);
	}
}
