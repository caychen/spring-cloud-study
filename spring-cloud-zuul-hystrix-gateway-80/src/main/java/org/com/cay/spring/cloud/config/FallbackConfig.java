package org.com.cay.spring.cloud.config;

import com.google.gson.Gson;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by caychen on 2018/6/22.
 */

//参考http://cloud.spring.io/spring-cloud-static/Edgware.SR3/single/spring-cloud.html#hystrix-fallbacks-for-routes
//在zuul中设置熔断器
@Configuration
public class FallbackConfig implements FallbackProvider {

	@Override
	public ClientHttpResponse fallbackResponse(Throwable cause) {
		if (cause instanceof HystrixTimeoutException) {
			return response(HttpStatus.GATEWAY_TIMEOUT);
		} else {
			return fallbackResponse();
		}
	}

	@Override
	public String getRoute() {
		//getRoute方法的返回值就是要监听的挂掉的微服务名字,*代表所有服务
		return "*";
	}

	@Override
	public ClientHttpResponse fallbackResponse() {
		return response(HttpStatus.INTERNAL_SERVER_ERROR);
	}

	private ClientHttpResponse response(final HttpStatus status) {
		return new ClientHttpResponse() {
			@Override
			public HttpStatus getStatusCode() throws IOException {
				return status;
			}

			@Override
			public int getRawStatusCode() throws IOException {
				return status.value();
			}

			@Override
			public String getStatusText() throws IOException {
				return status.getReasonPhrase();
			}

			@Override
			public void close() {
			}

			//熔断器中返回给调用者的数据
			@Override
			public InputStream getBody() throws IOException {
				Map<String, Object> result = new HashMap<>();
				result.put("status", "error");
				result.put("msg", "服务不可用");
				Gson gson = new Gson();
				String s = gson.toJson(result);
				return new ByteArrayInputStream(s.getBytes());
			}

			//添加响应头
			@Override
			public HttpHeaders getHeaders() {
				HttpHeaders headers = new HttpHeaders();
				headers.setContentType(MediaType.APPLICATION_JSON);
				return headers;
			}
		};
	}
}
