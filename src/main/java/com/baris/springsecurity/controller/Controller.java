package com.baris.springsecurity.controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.RequestMapping;
@org.springframework.stereotype.Controller
public class Controller {


    @GetMapping("/")
    public String showHome() {

        return "home";
    }
}
