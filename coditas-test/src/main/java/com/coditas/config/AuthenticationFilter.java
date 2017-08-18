package com.coditas.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class AuthenticationFilter extends GenericFilterBean {

  @Override
  public void doFilter(	ServletRequest request,ServletResponse response,
             			FilterChain filterChain)throws IOException, ServletException {
	  
    
   // SecurityContextHolder.getContext()
    //    .setAuthentication(authentication);
    
    filterChain.doFilter(request,response);
  }
}
