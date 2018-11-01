package com.example.sbo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Configuration
@EnableWebSecurity
public class WebApplicationConfig {
	
	@Autowired
	public UserAuthenticationProvider userAuthenticationProvider;
	
//	@Autowired
//	public Encoders encoders;
	
	@Autowired
	public void authenticationManager(AuthenticationManagerBuilder builder) throws Exception {
//		builder.authenticationProvider(userAuthenticationProvider).userDetailsService(null).passwordEncoder(encoders.userPasswordEncoder());
		builder.authenticationProvider(userAuthenticationProvider);
	}
}
