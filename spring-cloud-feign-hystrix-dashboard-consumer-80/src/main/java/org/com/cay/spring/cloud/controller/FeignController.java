package org.com.cay.spring.cloud.controller;

import org.com.cay.spring.cloud.service.IComputeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Cay on 2018/5/24.
 */
@RestController
public class FeignController {

	private static final Logger logger = LoggerFactory.getLogger(FeignController.class);

	@Autowired
	private IComputeService computeService;

	@RequestMapping("/compute/{a}/{b}")
	public String compute(@PathVariable Integer a, @PathVariable Integer b){
		logger.info("feign compute: {},{}", a, b);
		return computeService.compute(a, b);
	}
}
