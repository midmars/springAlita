package com.star.service.impl;

import com.star.domain.User;
import com.star.repository.UserRepository;
import com.star.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("com.star.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;

    @Override
    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }
}
