package com.iab.bootdrools.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {


	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE")
				.allowCredentials(true)
				.allowedOrigins("http://localhost:4200",
						"http://localhost", "http://localhost:8080",
						"http://localhost:8081",
						"http://localhost:8082",
						"http://localhost:3000",
						"http://localhost:3001",
						"http://localhost:9091"
						);
	}
}
