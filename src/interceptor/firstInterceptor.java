package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class firstInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse,
			Object obj, Exception exception) throws Exception {
		System.out.println("firstinterceptor afterCompletion  run");

	}

	@Override
	public void postHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj,
			ModelAndView modelandview) throws Exception {
		System.out.println("firstinterceptor postHandler  run");

	}

	@Override
	public boolean preHandle(HttpServletRequest httpservletrequest, HttpServletResponse httpservletresponse, Object obj)
			throws Exception {
		System.out.println("firstinterceptor preHandle  run");
		return true;
	}

}
