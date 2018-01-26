package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.enums.LoginStatus;
import com.springboot.springbootservices.model.User;
import com.springboot.springbootservices.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public String authenticate(@RequestBody User user){
        LoginStatus status = loginService.authenticate(user.getUsername(), user.getPassword());
        return status.name();
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@RequestBody User user){
        return loginService.register(user);
    }
}
