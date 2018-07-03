package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudEurekaServiceAProducer8001Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServiceAProducer8001Application.class, args);
	}
}
