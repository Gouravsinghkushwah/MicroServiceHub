package config;

 
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
//import org.springframework.security.config.web.server.ServerHttpSecurity;
//import org.springframework.security.web.server.SecurityWebFilterChain;
// 
//@Configuration
//@EnableWebFluxSecurity
public class SecurityConfig {

	
	
	//https://dev-83299496-admin.okta.com/admin/getting-started
	
//	@Bean
//	  SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity)
//	{
//		httpSecurity.authorizeExchange()
//		            .anyExchange()
//		            .authenticated()
//		            .and()
//		            .oauth2Client()
//		            .and()
//		            .oauth2ResourceServer()
//		            .jwt();
//		
//		return httpSecurity.build();
//		            
//	}
	
//	@SuppressWarnings("removal")
//	@Bean
//	SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity httpSecurity) {
//	    return httpSecurity
//	            .authorizeExchange(exchange -> exchange
//	                .anyExchange().authenticated()
//	            )
//	            .oauth2Client(ServerHttpSecurity.OAuth2ClientSpec::and)
//	            .oauth2ResourceServer(ServerHttpSecurity.OAuth2ResourceServerSpec::jwt)
//	            .build();
//	}

}
