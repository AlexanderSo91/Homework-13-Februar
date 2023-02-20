package com.example.homework6februar.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {

    @GetMapping
    public String index() {
        return "Приложение запущено";
    }
}
