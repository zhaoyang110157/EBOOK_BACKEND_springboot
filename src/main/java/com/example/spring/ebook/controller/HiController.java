package com.example.spring.ebook.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller // pay attention here
public class HiController {
    @RequestMapping("/hi")
    public String hi(){
        return "index";
    }
}
