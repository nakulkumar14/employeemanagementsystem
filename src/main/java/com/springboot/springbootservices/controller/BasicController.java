package com.springboot.springbootservices.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
@RequestMapping("/basic")
public class BasicController {

//    private static final String PATH = "/error";

    @RequestMapping(value = "/welcome")
    public String welcome() {
        String s = "test";
        log.info("Request for welcome : {}",s);
        return "Welcome, "+s;
    }

    @RequestMapping(value = "/s2",method = RequestMethod.GET)
    public String welcomePage(){
        return "index";
    }

    @RequestMapping(value = "/s1",method = RequestMethod.GET)
    public String welcomePage1(){
        return "index1";
    }

//    @Override
//    public String getErrorPath() {
//        return PATH;
//    }

    @ExceptionHandler(Exception.class)
    public ModelAndView globalExceptionHandler(Exception e) {
        ModelAndView modelAndView = new ModelAndView("error");
        modelAndView.addObject("message", e.getMessage());
        return modelAndView;
    }
}
