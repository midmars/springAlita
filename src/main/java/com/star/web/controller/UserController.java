package com.star.web.controller;

import com.star.domain.User;
import com.star.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.validation.Valid;

@Controller
@RequestMapping("/admin/user")
public class UserController {
    private static final String VIEW_INPUT = "/admin/user/input";
    private static final String VIEW_INDEX = "/admin/user/index";
    @Resource
    private UserService service;

    @RequestMapping("/index")
    public String index(){

        return "/admin/role/index";
    }
    @PostMapping("/input")
    public String input(Model model){
        User main = new User();
        model.addAttribute("main",main);

        return VIEW_INPUT;
    }

    @PostMapping("/add")
    public String save(@Valid @ModelAttribute("main") User main , BindingResult result, Model model){
        if(result.hasErrors()){
            model.addAttribute("main",main);
            return VIEW_INPUT;
        }
        service.save(main);
        return VIEW_INDEX;
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("main") User main,BindingResult result){
        if(result.hasErrors()){
            return VIEW_INPUT;
        }
        service.update(main);

        return VIEW_INDEX;
    }
}
