package com.example.market.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DeveloperController {

    @GetMapping("/developer")
    public String displayDeveloperPage(){
        return("/developer.html");
    }
}
