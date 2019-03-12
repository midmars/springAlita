package com.star.service.impl;

import com.star.domain.Role;
import com.star.domain.User;
import com.star.repository.RoleRepository;
import com.star.repository.UserRepository;
import com.star.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Service("com.star.service.impl.UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Resource
    private UserRepository userRepository;
    @Resource
    private PasswordEncoder passwordEncoder;
    @Resource
    private RoleRepository roleRepository;
    @Override
    public User findByUserId(String userId) {
        return userRepository.findByUserId(userId);
    }

    private static final String[] EXCLUDE_PROPERTIES = new String[]{
            "id"
    };
    @Override
    public void save(User source) {

            source.setPassword(passwordEncoder.encode(source.getPassword()));

            source.setLocked(false);
            Role role =roleRepository.findByNo("newUser");
            Set<Role> roles = new HashSet<>();
            roles.add(role);
            source.setRoles(roles);
            userRepository.save(source);
    }

    @Override
    public void update(User source) {

        User target = userRepository.findById(source.getId()).get();
        if(Objects.nonNull(target)){
            BeanUtils.copyProperties(source,target,EXCLUDE_PROPERTIES);
        }
        userRepository.save(source);
    }



}
