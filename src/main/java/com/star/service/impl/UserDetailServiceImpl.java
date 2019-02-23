package com.star.service.impl;

import com.star.domain.Role;
import com.star.domain.User;
import com.star.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.stream.Collectors;

@Transactional
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUserId(username);
        if(user==null){
            throw new UsernameNotFoundException("找不到使用者");
        }else{

            return new com.star.domain.UserDetails(user,
                    user.getRoles().stream().map(Role::getNo).collect(Collectors.toList()),
                    true, true, true, false);

        }
    }
}
