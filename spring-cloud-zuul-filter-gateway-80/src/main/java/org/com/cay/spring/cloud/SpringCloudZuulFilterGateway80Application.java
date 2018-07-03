package org.com.cay.spring.cloud;

import org.com.cay.spring.cloud.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy
public class SpringCloudZuulFilterGateway80Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZuulFilterGateway80Application.class, args);
	}

	@Bean
	public AccessFilter accessFilter(){
		return new AccessFilter();
	}
}
