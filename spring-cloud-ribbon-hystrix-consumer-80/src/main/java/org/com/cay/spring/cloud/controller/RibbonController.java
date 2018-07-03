package org.com.cay.spring.cloud.controller;

import org.com.cay.spring.cloud.service.IComputeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by caychen on 2018/6/21.
 */
@RestController
public class RibbonController {

	@Autowired
	private IComputeService computeService;

	@GetMapping("/compute/{a}/{b}")
	public String compute(@PathVariable Integer a, @PathVariable Integer b){
		String result = computeService.compute(a, b);
		return result;
	}
}
