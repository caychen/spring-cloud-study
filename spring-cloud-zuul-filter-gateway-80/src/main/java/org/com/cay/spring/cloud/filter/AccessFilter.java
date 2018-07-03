package org.com.cay.spring.cloud.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by caychen on 2018/6/22.
 */
public class AccessFilter extends ZuulFilter {

	private static Logger log = LoggerFactory.getLogger(AccessFilter.class);

	/**
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型，具体如下：
	 * pre：可以在请求被路由之前调用
	 * route：在路由请求时候被调用
	 * post：在route和error过滤器之后被调用
	 * error：处理请求时发生错误时被调用
	 *
	 * @return
	 */
	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

	//通过int值来定义过滤器的执行顺序
	@Override
	public int filterOrder() {
		return 0;
	}

	//返回一个boolean类型来判断该过滤器是否要执行，所以通过此函数可实现过滤器的开关，true表示该过滤器总是生效，false为失效。
	@Override
	public boolean shouldFilter() {
		return Boolean.TRUE;
	}

	//过滤器的具体逻辑
	@Override
	public Object run() {
		RequestContext context = RequestContext.getCurrentContext();
		HttpServletRequest request = context.getRequest();
		log.info(String.format("%s request to %s", request.getMethod(), request.getRequestURL().toString()));

		String token = request.getParameter("token");
		if (!StringUtils.hasText(token)) {
			log.warn("access token is empty");
			context.setSendZuulResponse(false);//令zuul过滤该请求，不对其进行路由
			context.setResponseStatusCode(401);//返回错误码
			return null;
		}
		log.info("access token ok");
		return null;
	}
}
