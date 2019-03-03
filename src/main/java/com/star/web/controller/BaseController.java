package com.star.web.controller;

import com.star.domain.Group;
import com.star.repository.GroupRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/baseBall-group")
public class BaseController {

    @Resource
    private GroupRepository repository;
    @RequestMapping("/input")
    public String input(Model model){
        Group group  = new Group();

        model.addAttribute("group",group);

        return "/admin/baseBall-group/input";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String save(@Valid Group group,Model model){

        repository.save(group);

        return "/admin/baseball";
    }
}
