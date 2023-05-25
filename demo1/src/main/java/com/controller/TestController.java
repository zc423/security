package com.controller;

import com.entity.UserEntity;
import com.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @Autowired
    private LoginService loginService;

    @GetMapping("test")
    public String get(){
        return "111";
    }

    @PostMapping("/user/login")
    public String login(@RequestBody UserEntity userEntity){
        String token = loginService.login(userEntity);
        return token;
    }
 }
