package com.example.demo;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyErrorController implements ErrorController{
    @GetMapping("/error")
    public String customError(){
        return "Check the link. Maybe you made a mistake or such link/command does not exist.";
    }
}
