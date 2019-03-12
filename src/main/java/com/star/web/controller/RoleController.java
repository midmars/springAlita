package com.star.web.controller;

import com.star.domain.Role;
import com.star.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/role")
public class RoleController {
    private static final String VIEW_INPUT = "/admin/role/input";
    private static final String VIEW_INDEX = "/admin/role/index";

    @Resource
    private RoleService roleService;
    @RequestMapping("/index")
    public String index(){

        return "/admin/role/index";
    }
    @PostMapping("/input")
    public String input(Model model){
        Role main = new Role();
        model.addAttribute("main",main);

        return "/admin/role/input";
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("main") Role main , BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("main",main);
            return VIEW_INPUT;
        }
        roleService.save(main);
        return VIEW_INDEX;
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("main") Role main,BindingResult result){
        if(result.hasErrors()){
            return VIEW_INPUT;
        }
        roleService.update(main);

        return VIEW_INDEX;
    }

}
