package com.devarifkhan.spring_mvc_with_thymeleaf.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    // a controller method to show the initial HTML form
    @RequestMapping("/showForm")
    public String showForm() {
        return "helloworld-form";
    }

    // need a controller method to process the HTML form
    @RequestMapping("/processForm")
    public String processForm() {
        return "helloworld";
    }

    // need a controller method to read form data and
    // add data to the model
    @RequestMapping("/processFormV2")
    public String letsShoutDude(HttpServletRequest request, Model model) {
        // read the request parameter from the HTML form
        String theName = request.getParameter("studentName");
        // convert the data to all caps
        theName = theName.toUpperCase();
        // create the message
        String result="Yo! " + theName;
        // add the name to the model
        model.addAttribute("message", result.toUpperCase());

        return "helloworld";
    }
}
