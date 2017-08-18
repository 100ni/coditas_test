package com.coditas.config;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.coditas.data.dto.User;
import com.coditas.service.UserService;

@Component
public class JpaAuthenticationProvider implements AuthenticationProvider {

	@Autowired
	private UserService userService;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		
		String username = (String) authentication.getPrincipal();
	    String password = (String) authentication.getCredentials();
	    
	    User user = userService.getUserByLoginId(username);
	    		
	    if(user == null) {
	    	throw new UsernameNotFoundException("User not found: " + username);
	    	
	    }
	    if (!password.equals(user.getPassword())) {
            throw new BadCredentialsException("Authentication Failed. Username or Password not valid.");
        }
	    
        return new UsernamePasswordAuthenticationToken(user, password, Collections.EMPTY_LIST);
		
	}

	@Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }

}
