package org.com.cay.spring.cloud.service.impl;

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

}
