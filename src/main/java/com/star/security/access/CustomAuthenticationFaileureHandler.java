package com.star.security.access;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
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
        System.err.println("Exception :"+exception.getLocalizedMessage());
        String errorMessage = "error";
        if (exception instanceof InternalAuthenticationServiceException) {
            log.error("blocked");
        }

        super.onAuthenticationFailure(request,response,exception);

        request.getSession().setAttribute(WebAttributes.AUTHENTICATION_EXCEPTION,errorMessage);
    }
}
