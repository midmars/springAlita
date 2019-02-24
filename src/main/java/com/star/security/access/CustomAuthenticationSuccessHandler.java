package com.star.security.access;

import com.star.domain.User;
import com.star.security.SecurityContext;
import org.springframework.security.core.Authentication;

import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component("customAuthenticationSuccessHandler")
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
        User user = SecurityContext.getUser();

        String now_url = httpServletRequest.getRequestURI().toUpperCase();
        String success_url="";
        if(now_url.indexOf("ADMIN")>=0  ){
            success_url="/admin/index";
        }

        httpServletResponse.sendRedirect(httpServletRequest.getContextPath()+success_url);
    }
}
