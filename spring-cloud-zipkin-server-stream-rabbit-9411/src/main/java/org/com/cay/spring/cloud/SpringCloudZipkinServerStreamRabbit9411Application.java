package org.com.cay.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.zipkin.stream.EnableZipkinStreamServer;

@SpringBootApplication
@EnableZipkinStreamServer//开启基于消息驱动的路径跟踪服务端,使用Stream方式启动ZipkinServer
public class SpringCloudZipkinServerStreamRabbit9411Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringCloudZipkinServerStreamRabbit9411Application.class, args);
	}
}
