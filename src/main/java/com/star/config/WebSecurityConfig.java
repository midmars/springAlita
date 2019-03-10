package com.star.config;


import jdk.nashorn.internal.ir.annotations.Reference;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;


import javax.annotation.Resource;

/**
 * Web Security 相關設定
 *
 * @author ricky
 */
@EnableWebSecurity
public class WebSecurityConfig {

    /**
     * 後端端相關設定
     */
    @Configuration
//    @Order()
    public static class WebSecurityConfigurer extends WebSecurityConfigurerAdapter {
        /**
         * 使用者服務，實現取得使用者登入資訊
         */
        @Resource
        private UserDetailsService userDetailsService;

//        @Resource
//        private AuthenticationProvider authenticationProvider;

        @Resource
        private  AuthenticationProvider authenticationProvider;
        @Resource(name="customAuthenticationSuccessHandler")
        private AuthenticationSuccessHandler authenticationSuccessHandler;

        @Resource(name = "customAuthenticationFaileureHandler")
        private AuthenticationFailureHandler authenticationFailureHandler;
        public WebSecurityConfigurer() {
            super();
            SecurityContextHolder.setStrategyName(SecurityContextHolder.MODE_INHERITABLETHREADLOCAL);
        }

        @Override
        public void configure(WebSecurity web) throws Exception {
            /*
             * 靜態資源
             */
            web.ignoring().antMatchers("/js/**", "/css/**", "/images/**");
            web.ignoring().antMatchers("/security/**");
            // web.ignoring().antMatchers("/public/login-index");
        }

        // @formatter:off
        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http
                    .antMatcher("/admin/**")
                    .authorizeRequests()
                    .antMatchers("/admin/login").permitAll()
                    .anyRequest().authenticated()
                    .and()
                    .formLogin().loginPage("/admin/login")
                    .loginProcessingUrl("/admin/login/process")
                    .defaultSuccessUrl("/baseball")
                    .successHandler(authenticationSuccessHandler)
                    .failureUrl("/admin/login")
                    .failureHandler(authenticationFailureHandler)
                    .and()
                    .logout().permitAll();



            http.csrf().disable();
            http.headers().frameOptions();
            http.headers().xssProtection().block(true);
        }
        // @formatter:on

        /*
         * 認證管理設定使用者服務
         *
         * (non-Javadoc)
         *
         * @see
         * org.springframework.security.config.annotation.web.configuration.
         * WebSecurityConfigurerAdapter#configure(org.springframework.security.
         * config.annotation.authentication.builders.
         * AuthenticationManagerBuilder)
         */
        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.authenticationProvider(authenticationProvider);
//           auth.userDetailsService(userDetailsService);
        }

//        /**
//         * CSRF例外網址
//         *
//         * @return CSRF例外網址
//         */
//        public RequestMatcher requestMatcher() {
//            CsrfRequestMatcher csrfRequestMatcher = new CsrfRequestMatcher();
//            csrfRequestMatcher.addExcludeUrl("/");
//            csrfRequestMatcher.addExcludeUrl("/public");
//            csrfRequestMatcher.addExcludeUrl("/public/index");
//            csrfRequestMatcher.addExcludeUrl("/public/login");
//            csrfRequestMatcher.addExcludeUrl("/public/login/process");
//            return csrfRequestMatcher;
//        }
    }


}