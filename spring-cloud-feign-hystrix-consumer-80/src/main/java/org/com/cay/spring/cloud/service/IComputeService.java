package org.com.cay.spring.cloud.service;

import feign.hystrix.FallbackFactory;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by Cay on 2018/5/24.
 */

/**
 * fallback属性标注: 回调类必须实现被这个注解标注的接口类，并标注为一个合法的spring bean
 *
 * Fallback class for the specified Feign client interface. The fallback class must
 * implement the interface annotated by this annotation and be a valid spring bean.
 */

/**
 * fallbackFactory属性标注: 回调类必须实现FallbackFactory，并需要产生一个被注解标注的接口类
 *
 * Define a fallback factory for the specified Feign client interface. The fallback
 * factory must produce instances of fallback classes that implement the interface
 * annotated by {@link FeignClient}. The fallback factory must be a valid spring
 * bean.
 *
 * @see FallbackFactory for details.
 */

//@FeignClient(name = "${service.name}")//绑定注册中心的服务名id
//@FeignClient(name = "${service.name}", fallback = FeignServiceHystrix.class)//绑定该接口对应注册中心的服务名，使用回调类进行错误回调
@FeignClient(name = "${service.name}", fallbackFactory = FeignServiceFactoryHystrix.class)
public interface IComputeService {

	@GetMapping("/compute/{a}/{b}")
	String compute(@PathVariable("a") Integer a, @PathVariable("b") Integer b);
}

@Configuration
class FeignServiceHystrix implements IComputeService{

	@Override
	public String compute(Integer a, Integer b) {
		return "feign发生error，返回-10000";
	}
}

@Component
class FeignServiceFactoryHystrix implements FallbackFactory<IComputeService>{

	@Override
	public IComputeService create(Throwable cause) {
		return (a, b) -> "feign发生error，返回-10001";
	}
}