//package com.example.sbo.config;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;
//
//@Configuration
//@EnableAuthorizationServer
//public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter{
//
//	@Autowired
//	private AuthenticationManager authenticationManager;
//	
//	public static final String RESOURCEID = "oauth2-resource";
//	
////	@Autowired
////	private DataSourceConfig dataSource;
//	
//	@Autowired
//	private DataSource dataSource;
//
//	/**
//	 * The AuthenticationManager for the password grant.
//	 * 
//	 */
//	@Override
//	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//		endpoints.authenticationManager(authenticationManager)
//				 .tokenStore(tokenStore());  
////				 .tokenStore(dataSource.tokenStore()); 
//	}
//	
//	/**
//	 * **************Spring Documentation*********************
//	 * 
//	 *  If the Resource Server and Authorization Server are in the same application and you use DefaultTokenServices then you 
//	 *  don't have to think too hard about this because it implements all the necessary interfaces so it is automatically consistent.
//	 *  
//	 *  If your Resource Server is a separate application then you have to make sure you match the capabilities of 
//	 *  the Authorization Server and provide a ResourceServerTokenServices that knows how to decode the tokens correctly. 
//	 *  
//	 *  RemoteTokenServices are convenient if there is not a huge volume of traffic in the Resource Servers (every request has 
//	 *  to be verified with the Authorization Server), or if you can afford to cache the results. 
//	 *  
//	 *  To use the /oauth/check_token endpoint you need to expose it by changing its access rule (default is "denyAll()") 
//	 *  in the AuthorizationServerSecurityConfigurer, e.g.
//	 *  
//	 *  @Override
//		public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
//			oauthServer.tokenKeyAccess("isAnonymous() || hasAuthority('ROLE_TRUSTED_CLIENT')")
//					   .checkTokenAccess("hasAuthority('ROLE_TRUSTED_CLIENT')");
//		}
//	 *  
//	 * Configuring both the /oauth/check_token endpoint and the /oauth/token_key endpoint. 
//	 * These two endpoints are protected by HTTP Basic authentication using client credentials.
//	 * 
//	 * Note that:
//		1) This RemoteTokenService will use CheckTokenEndPoint on Authorization Server to validate AccessToken and obtain 
//			Authentication object from it.
//		2) The can be found at AuthorizationServerBaseURL +”/oauth/check_token“
//		3) The Authorization Server can use any TokenStore type [JdbcTokenStore, JwtTokenStore, …] – this won’t affect the 
//			RemoteTokenService or Resource server.
//			
//	 * /oauth/check_token (used by Resource Servers to decode access tokens), and 
//	 * /oauth/token_key (exposes public key for token verification if using JWT tokens).
//	 */
//	
//	@Override
//	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//		security.tokenKeyAccess("permitAll()")
//				.checkTokenAccess("isAuthenticated()");
//	}
//	
//	@Override
//	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//	/*	clients.inMemory().withClient("client_id")
//				.authorizedGrantTypes("client_credentials","password","refresh_token")
//				.authorities("ROLE_CLIENT", "ROLE_TRUSTED_CLIENT")
//				.scopes("read", "write","trust")
//				.resourceIds(RESOURCEID)
//				.accessTokenValiditySeconds(120)
//				.refreshTokenValiditySeconds(240)
//				.secret("secret");*/
//		clients.jdbc(dataSource);
//	}
//	/**
//	 * Configuring our TokenStore to access the same database that authorization server uses to store access tokens.
//	 * The reason is that the Resource Server needs to be able to check the validity of the access tokens
//	 * issued by the Authorization Server.
//	 * Save the access_token in "oauth_access_token" table.
//	 * @return
//	 */
//	  
//	@Bean
//	public TokenStore tokenStore() {
//        return new JdbcTokenStore(dataSource);
//    }
//	
//}
