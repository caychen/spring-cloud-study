package org.com.cay.spring.cloud.service.impl;

import org.com.cay.spring.cloud.service.IComputeService;
import org.springframework.stereotype.Service;

/**
 * Created by Cay on 2018/5/24.
 */
@Service
public class ComputeServiceImpl implements IComputeService {

	@Override
	public Integer compute(Integer a, Integer b) {
		return a + b;
	}
}
