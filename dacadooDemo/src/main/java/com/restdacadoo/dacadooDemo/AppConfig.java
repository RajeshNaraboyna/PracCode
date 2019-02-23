package com.restdacadoo.dacadooDemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

	@Bean
	public String getJson() {
		return "{}";
	}

}
