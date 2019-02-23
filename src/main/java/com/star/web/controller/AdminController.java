package com.star.web.controller;

import com.star.domain.Group;
import com.star.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Controller("com.star.web.controller.AdminController")
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private GroupRepository groupRepository;


    @RequestMapping("/index")
    public String index(){

        return "/admin/index";}
    @RequestMapping("/login")
    public String login(){

        return "/admin/login-index";}




    @GetMapping("/baseball")
    @ResponseBody
    private List<Group> getGroup(){
        return groupRepository.findAll().stream().collect(Collectors.toList());
    }

}
