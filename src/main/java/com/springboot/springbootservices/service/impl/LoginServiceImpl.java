package com.springboot.springbootservices.service.impl;

import com.springboot.springbootservices.dao.UserRepository;
import com.springboot.springbootservices.enums.LoginStatus;
import com.springboot.springbootservices.model.User;
import com.springboot.springbootservices.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;

@Slf4j
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public LoginStatus authenticate(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user!=null){
            String encrpytedPassword = getMD5(password);
            if (user.getPassword().equals(encrpytedPassword)){
                return LoginStatus.SUCCESS;
            }
            return LoginStatus.INVALID_PASSWORD;
        }
        return LoginStatus.INVALID_USER;
    }

    @Override
    public boolean register(User user) {
        try {
            if (userRepository.findByUsername(user.getUsername()) == null) {

                String md5 = getMD5(user.getPassword());
                if (StringUtils.isEmpty(md5)) {
                    return false;
                }

                user.setPassword(md5);
                user.setCreatedAt(new Date());
                user.setUpdatedAt(new Date());
                user.setInvalidPasswordAttempts(0);
                userRepository.save(user);
                return true;
            }
        }catch (Exception e){
            log.error("Error : ",e);
        }
        return false;
    }

    private String getMD5(String password){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] messageDigest = md.digest(password.getBytes());
            BigInteger number = new BigInteger(1, messageDigest);
            String hashtext = number.toString(16);
            return hashtext;
        } catch (NoSuchAlgorithmException e) {
            log.error("Error ",e);
        }
        return null;
    }
}
