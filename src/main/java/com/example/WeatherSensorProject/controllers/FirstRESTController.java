package com.example.WeatherSensorProject.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api")
public class FirstRESTController {

    // Обработчик GET-запроса для пути "/api/sayHello"
    @GetMapping("/sayHello")
    public String sayHello() {
         return "Hello world!";
    }
}
