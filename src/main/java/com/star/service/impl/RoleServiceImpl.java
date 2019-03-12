package com.star.service.impl;


import com.star.domain.Role;
import com.star.repository.RoleRepository;
import com.star.service.RoleService;
import org.springframework.beans.BeanUtils;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.Objects;

public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleRepository roleRepository;
    private static final String[] EXCLUDE_PROPERTIES = new String[]{
            "id"
    };
    @Override
    public void save(Role source) {
        roleRepository.save(source);
    }

    @Override
    public void update(Role source) {

        Role target = roleRepository.findById(source.getId()).get();
        if(Objects.nonNull(target)){
            BeanUtils.copyProperties(source,target,EXCLUDE_PROPERTIES);
        }
        roleRepository.save(source);
    }
}
