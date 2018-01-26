package com.springboot.springbootservices.enums;

public enum Gender {
    M("M"),
    F("F");

    private String name;

    private Gender(String name) {
        this.name = name;
    }
}
