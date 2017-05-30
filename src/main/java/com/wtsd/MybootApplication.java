package com.wtsd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class MybootApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybootApplication.class, args);
	}

	@Bean
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		MyFilter myFilter = new MyFilter();
		registrationBean.setFilter(myFilter);
		List<String> urlPatterns = new ArrayList<String>();
		urlPatterns.add("/*");
		registrationBean.setUrlPatterns(urlPatterns);
		return registrationBean;
	}
}
