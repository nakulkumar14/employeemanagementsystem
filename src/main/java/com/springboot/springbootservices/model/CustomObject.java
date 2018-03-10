package com.springboot.springbootservices.model;


import com.springboot.springbootservices.enums.Gender;
import lombok.Data;

@Data
public class CustomObject {

    private Gender gender;
    private String gen;
    private long count;

    public CustomObject(Gender gender, long count) {
        this.gender = gender;
        this.count = count;
    }
}
