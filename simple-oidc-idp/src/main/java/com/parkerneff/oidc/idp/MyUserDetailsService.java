package com.parkerneff.oidc.idp;

import com.parkerneff.oidc.idp.ext.CustomUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.*;

public class MyUserDetailsService implements UserDetailsService {
    private static Map<String, CustomUser> users = new HashMap<>();

    public MyUserDetailsService() {
        //in a real application, instead of using local data,
        // we will find user details by some other means e.g. from an external system
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        users.put("user",  new CustomUser("user", "password", grantedAuthorities));
        grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_ADMINM"));
        users.put("admin", new CustomUser("mike", "234", grantedAuthorities));
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = users.get(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found by name: " + username);
        } else {
            return user;

        }

    }


}
