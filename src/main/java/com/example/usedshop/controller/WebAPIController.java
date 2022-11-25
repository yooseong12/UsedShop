package com.example.usedshop.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class WebAPIController {

    @GetMapping("/name")
    public String name() {
        return "내이름";
    }
}
