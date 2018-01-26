package com.springboot.springbootservices.response;

import lombok.Data;

import java.io.Serializable;

public @Data class ServiceResponse{
    private String response;
    private Exception exception;
}
