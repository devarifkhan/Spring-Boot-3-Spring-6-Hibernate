package com.devarifkhan.rest_crud_apis.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class RestControllerApi {
    // add code for the "/hello" endpoint
    @RequestMapping("/hello")
    public String hello() {
        return "Hello, World!";
    }
}
