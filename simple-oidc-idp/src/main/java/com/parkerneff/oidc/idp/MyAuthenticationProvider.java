package com.parkerneff.oidc.idp;

import com.parkerneff.oidc.idp.ext.CustomUser;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.List;

public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
    private Log log =  LogFactory.getLog(MyAuthenticationProvider.class);

    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        log.info("more auth checks");
    }

//    @Override
//    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//        log.info("authentication");
//        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
//
//        String user = authentication.getName();
//        String password = authentication.getCredentials().toString();
//
//        if ("password".equals(password)) {
//            if ("user".equals(user)) {
//                return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
//
//            } else if ("admin".equals(user)) {
//                grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
//                return new UsernamePasswordAuthenticationToken(user, password, grantedAuthorities);
//
//            } else {
//                throw new AuthenticationCredentialsNotFoundException("hello");
//            }
//        }
//
//
//        throw new AuthenticationCredentialsNotFoundException("goodby");
//    }

    @Override
    protected UserDetails retrieveUser(String s, UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken) throws AuthenticationException {
        log.info("auth user=" + s);
        log.info("auth passowrd=" + usernamePasswordAuthenticationToken.getCredentials().toString());

        if (!"password".equals(usernamePasswordAuthenticationToken.getCredentials() )) {
            throw new AuthenticationCredentialsNotFoundException("goodby");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMINM"));
       return new CustomUser("user", "password", grantedAuthorities);


    }
}
