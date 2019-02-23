package com.star.web.controller;

import com.star.domain.Group;
import com.star.repository.GroupRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GroupController {

    @Resource
    private GroupRepository groupRepository;

    @GetMapping("/baseball")
    private List<Group> getGroup(){
        return groupRepository.findAll().stream().collect(Collectors.toList());
    }
}
