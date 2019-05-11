package com.paper.question.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.DelegatingFilterProxy;


@SpringBootApplication
public class QuestionWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuestionWebApplication.class, args);
	}

	private CorsConfiguration buildConfig(){
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOrigin("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		return corsConfiguration;
	}

	@Bean
	public CorsFilter corsFilter(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**",buildConfig());
		return new CorsFilter(source);
	}
//	@Bean
//	public FilterRegistrationBean delegatingFilterProxy(){
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		DelegatingFilterProxy proxy = new DelegatingFilterProxy();
//		proxy.setTargetFilterLifecycle(true);
//		proxy.setTargetBeanName("shiroFilter");
//		filterRegistrationBean.setFilter(proxy);
//		return filterRegistrationBean;
//	}
//
//	@Bean("shiroFilter")
//	public ShiroFilterFactoryBean shiroFilterFactoryBean() {
//		ShiroFilterFactoryBean filterFactoryBean = new ShiroFilterFactoryBean();
//		return filterFactoryBean;
//	}
//	@Bean
//	public FilterRegistrationBean shiroFilterRegistration() {
//		//		DelegatingFilterProxy
//
//		FilterRegistrationBean registration = new FilterRegistrationBean();
//		registration.setFilter(new DelegatingFilterProxy("shiroFilter"));
//		//该值缺省为false，表示生命周期由SpringApplicationContext管理，设置为true则表示由ServletContainer管理
//		registration.addInitParameter("targetFilterLifecycle", "true");
//		registration.setEnabled(true);
//		registration.addUrlPatterns("/**");
//		return registration;
//	}
	
}
