package org.example.spring.cloud.booking.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${message:Hello Welcome to Application}")
    private String message;
    @GetMapping
    public String index(){
        return message;
    }
}
