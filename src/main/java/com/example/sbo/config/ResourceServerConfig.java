//package com.example.sbo.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
//
//@Configuration
//@EnableResourceServer
//public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
//	
//	@Override
//	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
////		RemoteTokenServices tokenServices = new RemoteTokenServices();
////		tokenServices.setCheckTokenEndpointUrl("http://localhost:8090/springoauth/oauth/check_token");
//		
//		resources.resourceId(AuthorizationServerConfig.RESOURCEID);
////				.tokenServices(tokenServices);
//	}
//	
//	@Override
//	public void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests()
//			.antMatchers("/","/home").permitAll()
//			.anyRequest().authenticated();
//	}
//	
//}
