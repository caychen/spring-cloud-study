package org.com.cay.spring.cloud.controller;

import org.com.cay.spring.cloud.service.IComputeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cay on 2018/5/24.
 */
@RestController
@RequestMapping("/compute")
public class ComputeController {

	private static final Logger logger = LoggerFactory.getLogger(ComputeController.class);

	@Autowired
	private IComputeService computeService;

	@GetMapping("/{a}/{b}")
	public String minus(@PathVariable Integer a, @PathVariable Integer b) {
		Integer result = computeService.compute(a, b);
		logger.info("producer-3计算的是减法，结果是：{}", result);
		return "producer-3计算的是减法，结果是：" + result;
	}

}
