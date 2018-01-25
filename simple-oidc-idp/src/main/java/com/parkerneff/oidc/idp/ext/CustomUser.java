package com.parkerneff.oidc.idp.ext;

import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

public class CustomUser extends User {
    @Getter @Setter String firstName;
    @Getter @Setter String lastName;

    public CustomUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        this.firstName = "Parker";
        this.lastName = "Neff";
    }
}
