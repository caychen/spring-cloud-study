package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import zipkin.server.EnableZipkinServer;

@SpringBootApplication
@EnableEurekaClient
@EnableZipkinServer//开启zipkin服务
public class SpringCloudZipkinServer9411Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinServer9411Application.class, args);
	}
}
