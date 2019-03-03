package com.star.security.authentication;

import com.star.domain.User;
import com.star.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

@Component("com.star.security.authentication.AuthenticationProvider")
@Slf4j
public class AuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {

    @Resource
    private UserDetailsService userDetailsService;


    private PasswordEncoder passwordEncoder;

    @Resource
    private UserService userService;

    public AuthenticationProvider() {setPasswordEncoder( new BCryptPasswordEncoder());}

    private void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        Assert.notNull(passwordEncoder, "passwordEncoder cannot be null");


        this.passwordEncoder = passwordEncoder;
    }
    @Override
    protected void additionalAuthenticationChecks(UserDetails userDetails, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
                log.debug("authentication.getName()="+authentication.getName());

                User user = userService.findByUserId(authentication.getName());
//                if(null==authentication.getCredentials()||!getPasswordEncoder().matches(authentication.getCredentials().toString(),user.getPassword().toString())){
//                    log.error("驗證錯誤");
//
//                    throw new BadCredentialsException("驗證錯誤");
//                }
                if(null==authentication.getCredentials()||!authentication.getCredentials().toString().equals(user.getPassword())){
                    log.error("帳號密碼錯誤");

                    throw new BadCredentialsException("Bad Credential");
                }
    }

    @Override
    protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
        UserDetails loadUser = null;

        String password = (authentication.getCredentials()!=null)?authentication.getCredentials().toString():"";
        System.err.println("userId :"+username+" password:"+password);
        try{
            loadUser =getUserDetailsService().loadUserByUsername(username);

        }catch (UsernameNotFoundException notFound){
            throw  notFound;
        }
        if(loadUser==null){
            throw  new InternalAuthenticationServiceException(
                    "userDetails returned null"
            );
        }
        return loadUser;
    }
    protected  PasswordEncoder getPasswordEncoder(){
        return passwordEncoder;
    }
    protected  UserDetailsService getUserDetailsService(){
        return userDetailsService;
    }
}
