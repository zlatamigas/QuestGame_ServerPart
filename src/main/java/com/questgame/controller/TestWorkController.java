package com.questgame.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestWorkController {


    @GetMapping("/welcome")
    public String testHello(){
        return "Welcome! Controller works?";
    }
}
