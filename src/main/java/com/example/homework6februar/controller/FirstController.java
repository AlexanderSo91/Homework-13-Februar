package com.example.homework6februar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstController {

    @GetMapping
    public String index() {
            return "Приложение запущено";
    }


    @GetMapping("info")
    public String info () {
        return "Ученик: Зотин Александр. </br> +" +
                " Название проекта: recipe-backend-app.</br> +" +
                " Дата создания проекта: 05.02.2023.</br> +" +
                " Описание проекта: приложения для сайта рецептов";
    }

}

