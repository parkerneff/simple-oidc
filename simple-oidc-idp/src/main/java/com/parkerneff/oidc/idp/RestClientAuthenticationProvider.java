package com.parkerneff.oidc.idp;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class RestClientAuthenticationProvider  implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

        String user = authentication.getName();
        String password = authentication.getCredentials().toString();

        if ("password".equals(password)) {
            if ("user".equals(user)) {
                return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);

            } else if ("admin".equals(user)) {
                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
                return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);

            } else {
                throw new AuthenticationCredentialsNotFoundException("hello");
            }
        }


        throw new AuthenticationCredentialsNotFoundException("goodby");
    }

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(
                UsernamePasswordAuthenticationToken.class);
    }
}
