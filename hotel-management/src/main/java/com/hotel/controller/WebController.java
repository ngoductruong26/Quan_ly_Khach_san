package com.hotel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping("/")
    public String home(){
        return "home";
    }

    @GetMapping("/dashboard")
    public String dashboard(){
        return "index";
    }

}

