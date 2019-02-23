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
import org.springframework.context.annotation.Bean;

import java.util.Set;
import java.util.stream.Stream;

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
}
