1、在Config Client端添加actuator监控
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-actuator</artifactId>
</dependency>
```

2、在application.properties/yml中添加
```properties
# 默认开通了安全认证，所以修改为false，配合@RefreshScope注解
management.security.enabled=false
```

3、需要给加载变量的类上面加载@RefreshScope，在客户端执行post /refresh的时候就会更新此类下面的变量值。

一旦配置中心有配置发送改变，只需往客户端发送post请求的/refresh，然后再发送请求，就会读取到新的配置信息。