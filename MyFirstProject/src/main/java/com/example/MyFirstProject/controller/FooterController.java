package com.example.MyFirstProject.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FooterController {

    @GetMapping("/privacy")
    public String privacy() {
        return "articles/privacy";
    }

    @GetMapping("/terms")
    public String terms() {
        return "articles/terms";
    }
}


