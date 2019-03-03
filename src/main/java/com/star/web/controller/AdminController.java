package com.star.web.controller;

import com.star.domain.Group;
import com.star.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@Controller("com.star.web.controller.AdminController")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/admin")
public class AdminController {

    @Resource
    private GroupRepository groupRepository;


    @RequestMapping("/index")
    public String index(){

        return "/index";}
    @RequestMapping("/login")
    public String login(){

        return "/admin/login";}




    @PostMapping("/baseball")
    @ResponseBody
    private List<Group> getGroup(){
        return groupRepository.findAll().stream().collect(Collectors.toList());
    }

}
