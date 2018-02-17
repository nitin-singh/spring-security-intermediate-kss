package com.springmvc.authenticationProvider;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();
        if (!isAuthenticationSupported(authentication)) {
            return null;
        }

        if (!isThirdPartyAuthenticated()) {
            throw new BadCredentialsException("Credentials Not Supported");
        } else {
            return new UsernamePasswordAuthenticationToken(name, password, new ArrayList<GrantedAuthority>(Arrays.asList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }

    boolean isAuthenticationSupported(Authentication authentication) {
        return true;
    }

    boolean isThirdPartyAuthenticated() {
        return true;
    }

}
