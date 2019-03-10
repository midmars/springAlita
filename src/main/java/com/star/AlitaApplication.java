package com.star;

import com.star.domain.Group;
import com.star.domain.Role;
import com.star.domain.User;
import com.star.repository.GroupRepository;
import com.star.repository.RoleRepository;
import com.star.repository.UserRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.core.Ordered;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Stream;

@EnableResourceServer
@SpringBootApplication
public class AlitaApplication {

	public static void main(String[] args) {
		SpringApplication.run(AlitaApplication.class, args);
	}


//	@Bean
//	String init(UserRepository userRepository, RoleRepository roleRepository) {
//
//		User  user = new User();
//		user.setUserId("admin");
//		user.setPassword("admin");
//
//		Role role = new Role();
//		role.setName("系統管理員");
//		role.setNo("ROLE_ADMIN");
//		roleRepository.save(role);
//
//		user.getRoles().add(role);
//		userRepository.save(user);
//
//		return "OK";
//	}

	@Bean
	public FilterRegistrationBean<CorsFilter> simpleCorsFilter() {
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowCredentials(true);
		config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
		config.setAllowedMethods(Collections.singletonList("*"));
		config.setAllowedHeaders(Collections.singletonList("*"));
		source.registerCorsConfiguration("/**", config);
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<>(new CorsFilter(source));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}
}
