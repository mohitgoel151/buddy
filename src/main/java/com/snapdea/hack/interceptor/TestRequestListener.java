package com.snapdea.hack.interceptor;

import org.apache.log4j.Logger;
import org.apache.log4j.MDC;
import 	org.apache.log4j.spi.LoggerFactory;

import javax.servlet.ServletRequest;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class TestRequestListener implements ServletRequestListener {

	//protected static final Logger LOGGER = LoggerFactory.getLogger(TestRequestListener.class);
	@Override
	public void requestInitialized(ServletRequestEvent servletRequestEvent) {

		//LOGGER.debug("++++++++++++ REQUEST INITIALIZED +++++++++++++++++");
	    //GENERATE some unique ID
	    MDC.put("RequestId", "mohit");

	    ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("ServletRequest initialized. Remote IP="+servletRequest.getRemoteAddr());
    
	}
	
	@Override
	public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
		ServletRequest servletRequest = servletRequestEvent.getServletRequest();
        System.out.println("ServletRequest destroyed. Remote IP="+servletRequest.getRemoteAddr());
  
	}



}
