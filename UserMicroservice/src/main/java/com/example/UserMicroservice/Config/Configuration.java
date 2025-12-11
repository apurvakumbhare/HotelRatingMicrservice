package com.example.UserMicroservice.Config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
@Component
public class Configuration {


	@Bean
	@LoadBalanced
	public RestTemplate template() {
		return new RestTemplate();
	}
}
