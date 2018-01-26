package com.springboot.springbootservices.enums;

public enum LoginStatus {

    SUCCESS("SUCCESS"),
    INVALID_PASSWORD("INVALID_PASSWORD"),
    INVALID_USER("INVALID_USER");

    private String name;

    private LoginStatus(String name){
        this.name = name;
    }
}
