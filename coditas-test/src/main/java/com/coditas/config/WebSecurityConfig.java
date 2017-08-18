package com.coditas.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	public static final String REST_LOGIN_ENTRY_POINT = "/user/login";
	 
	@Autowired
	private JpaAuthenticationProvider jpaAuthenticationProvider;
	
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	      auth.authenticationProvider(jpaAuthenticationProvider);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		 http
		 	.csrf().disable()
		 	.cors()
		 	
		    .and()
		    .authorizeRequests()
	        .antMatchers(HttpMethod.POST, REST_LOGIN_ENTRY_POINT).permitAll();
	        //.anyRequest().authenticated()
	        
	        //.and()
	        //.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	        
	        //.and()
	        // And filter other requests to check the presence of JWT in header
	       	
    }
	
	@Bean
	CorsConfigurationSource corsConfigurationSource(){
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		 CorsConfiguration config = new CorsConfiguration();
		 config.setAllowCredentials(true);
		    config.addAllowedOrigin("*");
		    config.addAllowedHeader("*");
		    config.addAllowedMethod("OPTIONS");
		    config.addAllowedMethod("HEAD");
		    config.addAllowedMethod("GET");
		    config.addAllowedMethod("PUT");
		    config.addAllowedMethod("POST");
		    config.addAllowedMethod("DELETE");
		    config.addAllowedMethod("PATCH");
		    source.registerCorsConfiguration("/**", config);
			return source;
	}
	
}
