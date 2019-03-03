package com.star.security.access;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Component("customAuthenticationFaileureHandler")
@Slf4j
public class CustomAuthenticationFaileureHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException exception)
            throws IOException, ServletException {
        setDefaultFailureUrl("/admin/login");
        System.err.println("Exception :"+exception.getLocalizedMessage());
        String errorMessage = "error";
        if (exception instanceof InternalAuthenticationServiceException) {
            log.error("blocked");
        }
        if(exception instanceof BadCredentialsException){
            errorMessage="帳號密碼錯誤";
        }
        if(exception instanceof LockedException){
            errorMessage="帳號已鎖住，請通知管理員";
        }
        super.onAuthenticationFailure(request,response,exception);

        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,errorMessage);
    }
}
