package com.snapdeal.messaging.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.snapdea.hack.interceptor.SampleInterceptor;

@Configuration
public class AppMVCConfig extends WebMvcConfigurerAdapter {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("chatPdp");
        registry.addViewController("/home").setViewName("index");
        registry.addViewController("/iphone").setViewName("IphonePdp");
        registry.addViewController("/dashboard").setViewName("dashboard");
        registry.addViewController("/snapdeal").setViewName("home");
        registry.addViewController("/review").setViewName("chatPdp2");

       }
  
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
        .addResourceLocations("/resources/**")
        .setCachePeriod(31556926);
     }
    
    @Bean
    public SampleInterceptor sampleInterceptor() {
        return new SampleInterceptor();
    }
    
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(sampleInterceptor());
    }
 }
