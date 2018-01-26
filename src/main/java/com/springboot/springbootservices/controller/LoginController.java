package com.springboot.springbootservices.controller;

import com.springboot.springbootservices.enums.LoginStatus;
import com.springboot.springbootservices.model.User;
import com.springboot.springbootservices.response.ServiceResponse;
import com.springboot.springbootservices.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ServiceResponse authenticate(@RequestBody User user){
        LoginStatus status = loginService.authenticate(user.getUsername(), user.getPassword());
        ServiceResponse response = new ServiceResponse();
        response.setResponse(status.name());
        return response;
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public boolean register(@RequestBody User user){
        return loginService.register(user);
    }
}
