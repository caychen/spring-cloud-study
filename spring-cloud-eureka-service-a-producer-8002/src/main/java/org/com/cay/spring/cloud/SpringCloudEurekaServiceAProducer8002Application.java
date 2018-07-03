package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SpringCloudEurekaServiceAProducer8002Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudEurekaServiceAProducer8002Application.class, args);
	}
}
