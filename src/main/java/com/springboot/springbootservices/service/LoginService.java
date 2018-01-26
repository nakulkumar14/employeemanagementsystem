package com.springboot.springbootservices.service;

import com.springboot.springbootservices.enums.LoginStatus;
import com.springboot.springbootservices.model.User;

public interface LoginService {
    LoginStatus authenticate(String username, String password);

    boolean register(User user);
}
