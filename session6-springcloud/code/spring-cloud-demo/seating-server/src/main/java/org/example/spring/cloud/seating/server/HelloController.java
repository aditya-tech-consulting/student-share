package org.example.spring.cloud.seating.server;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class HelloController {

    @Value("${message}")
    private String message;
    @GetMapping
    public String index(){
        return message;
    }
}
