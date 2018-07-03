package org.com.cay.spring.cloud.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.com.cay.spring.cloud.service.IComputeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by Cay on 2018/5/24.
 */
@Service
public class ComputeServiceImpl implements IComputeService {

	private static final Logger logger = LoggerFactory.getLogger(ComputeServiceImpl.class);

	@Value("${service.name}")
	private String serviceName;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private DiscoveryClient discoveryClient;

	/**
	 * https://github.com/Netflix/Hystrix/tree/master/hystrix-contrib/hystrix-javanica#configuration
	 *
	 * @HystrixCommand：用于指定回调方法，其中
	 *  commandKey默认为方法名，本例为compute
	 *  groupKey默认为类名，本例为ConsumerService
	 */

	//指定回调方法，注意：回调方法参数必须与原函数的参数个数和顺序需要保持一致，即本例中的compute和fallbackMethod的参数个数和顺序要一致
	@HystrixCommand(fallbackMethod = "fallbackMethod",
			commandProperties = @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "20000"))
	@Override
	public String compute(Integer a, Integer b) {

		List<ServiceInstance> instances = discoveryClient.getInstances(serviceName);
		logger.info("instances.size(): {}", instances.size());

		instances.forEach(instance -> System.out.println(instance.getUri()));

		logger.info("ribbon compute: " + a + "," + b);
		String serviceUri = "http://" + serviceName + "/compute/" + a + "/" + b;
		logger.info("serviceUri: {}", serviceUri);
		return restTemplate.getForObject("http://" + serviceName + "/compute/{a}/{b}", String.class, a, b);
	}

	private String fallbackMethod(Integer a, Integer b){
		return "ribbon发生error，返回-9999";
	}
}
