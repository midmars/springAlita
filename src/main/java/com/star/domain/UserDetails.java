package com.star.domain;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserDetails extends org.springframework.security.core.userdetails.User {

    private User user;
    private List<String> roles;

    public UserDetails(User user, List<String> roles) {
        super(user.getUserId(), user.getPassword(),
                roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        this.user = user;
        this.roles = roles;
    }

    public UserDetails(User user, List<String> roles, boolean enabled,
                       boolean accountNonExpired, boolean credentialsNonExpired,
                       boolean accountNonLocked) {
        super(user.getUserId(), user.getPassword(), enabled, accountNonExpired,
                credentialsNonExpired, accountNonLocked,
                roles.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
        this.user = user;
        this.roles = roles;
    }

    public User getUser() {
        return user;
    }

    public List<String> getRoles() {
        return roles;
    }
}
