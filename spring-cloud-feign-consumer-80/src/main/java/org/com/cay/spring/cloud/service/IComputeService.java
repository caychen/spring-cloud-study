package org.com.cay.spring.cloud.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Cay on 2018/5/24.
 */

@FeignClient(name = "${service.name}")//绑定注册中心的服务名id
public interface IComputeService {

	@GetMapping("/compute/{a}/{b}")
	String compute(@PathVariable("a") Integer a, @PathVariable("b") Integer b);
}