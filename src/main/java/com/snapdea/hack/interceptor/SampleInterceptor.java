package com.snapdea.hack.interceptor;

import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class SampleInterceptor extends HandlerInterceptorAdapter {

	private static final Logger logger = Logger.getLogger(SampleInterceptor.class);
	
	/**
	 * 
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
		throws Exception {
		System.out.println("Calling preHandle");
		
		request.setAttribute("requestId", UUID.randomUUID().toString());

		long startTime = System.currentTimeMillis();
		request.setAttribute("startTime", startTime);
		
		//TODO
		HttpSession session = request.getSession();
		ServletContext servletContext = request.getServletContext();
		ServletRequest servletRequest = request;
		servletRequest.getServerName();
		//session.
		
		return super.preHandle(request, response, handler);
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void postHandle(
			HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView)
			throws Exception {
		System.out.println("Calling postHandle");
		
		long startTime = (Long)request.getAttribute("startTime");
		long endTime = System.currentTimeMillis();
		long executeTime = endTime - startTime;
		if(logger.isDebugEnabled()){
			   logger.debug("[" + handler + "] executeTime : " + executeTime + "ms");
		}
		super.postHandle(request, response, handler, modelAndView);
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterCompletion(
			HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
//		"request.getHeaderNames().toString()"	 
//		"request.getMethod()"	                 => GET
//		"request.getPathInfo()"	      			 => null
//		"request.getQueryString()"	  			 => null
//		"request.getRemoteUser()"	  			 => null
//		"request.getRequestedSessionId()"		 => null
//		"request.getRequestURI()"	  			 => /user/3/similarcategory/45
//		"request.getRequestURL().toString()" 	 => http://localhost:8080/user/3/similarcategory/45	 
//		"request.getServletPath()"	  			 => /user/3/similarcategory/45
//		"request.getSession().getId()"	 		 => 45D972885676460801BB08835B41562E
//		"request.getHeader("host")"	 			 => localhost:8080
		System.out.println("Calling afterCompletion");
		super.afterCompletion(request, response, handler, ex);
		
	}

	/**
	 * This implementation is empty.
	 */
	@Override
	public void afterConcurrentHandlingStarted(
			HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("Calling afterCompletion");
		super.afterConcurrentHandlingStarted(request, response, handler);
	}
	
	
}
