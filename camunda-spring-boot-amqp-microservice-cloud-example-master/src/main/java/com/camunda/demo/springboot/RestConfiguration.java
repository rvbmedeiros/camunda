package com.camunda.demo.springboot;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestConfiguration {

	@Bean
	public RestTemplate createRestTemplate() {
		RestTemplate restTemplate = new RestTemplate();
		List<HttpMessageConverter<?>> messageConverters = new ArrayList<>();
		System.out.println("mutreeeeeeeeta");
		restTemplate.setMessageConverters(messageConverters);
		return restTemplate;

	}
}
