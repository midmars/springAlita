package com.star.web.controller;

import com.star.domain.Group;
import com.star.domain.User;
import com.star.repository.GroupRepository;
import com.star.repository.UserRepository;
import com.star.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:4200")
public class UserApiController {

    @Resource
    private UserRepository repository;
    @Resource
    private UserService userService;

    @GetMapping("/list")
    private List<User> getGroup(){
        return repository.findAll().stream().collect(Collectors.toList());
    }


    @PostMapping("/save")
    private String save(@RequestBody User source){
        userService.save(source);

        return "ok";
    }
    @GetMapping("/update/{id}")
    public User findOne(@PathVariable("id") String id){
        return userService.findOne(id);
    }

    @PostMapping("/add")
    public String update(@RequestBody User user){
        userService.update(user);
        return "OK";

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){
        userService.delete(id);
    }
}
