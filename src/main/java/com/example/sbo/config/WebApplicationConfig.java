package com.example.sbo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
public class WebApplicationConfig {
	
	@Autowired
	UserAuthenticationProvider userAuthenticationProvider;
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
		builder.authenticationProvider(userAuthenticationProvider);
	}
}
