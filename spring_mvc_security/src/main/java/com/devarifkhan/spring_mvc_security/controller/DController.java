package com.devarifkhan.spring_mvc_security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DController {

    @GetMapping("/")
    public String showHome() {
        return "home";
    }

    // add a request for  /leaders
    @GetMapping("/leaders")
    public String showLeaders() {
        return "leaders";
    }

    // add a request for  /leaders
    @GetMapping("/systems")
    public String showSystems() {
        return "systems";
    }

    @GetMapping("/access-denied")
    public String showAccessDenied() {
        return "access-denied";
    }
}
