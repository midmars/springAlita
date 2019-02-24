package com.star.security;

import com.star.domain.User;
import com.star.domain.UserDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class SecurityContext {

    public SecurityContext(){
    }

    public static User getUser(){
        User user = null;

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            Object principal = auth.getPrincipal();
            if(principal instanceof UserDetails){
                user = ((UserDetails) principal).getUser();
            }
        }
        return  user;
    }
}
