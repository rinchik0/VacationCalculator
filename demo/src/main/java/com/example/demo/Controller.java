package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
    @GetMapping("/calculacte_with_dates")
    public String calculate(@RequestParam() Double salary, @RequestParam() Integer days, @RequestParam() String beginDate){
        ResponseGenerator generator = new ResponseGenerator();
        return generator.vacationResponse(salary, days, new Date(beginDate));
    }

    @GetMapping("/calculacte")
    public String calculate(@RequestParam() Double salary, @RequestParam() Integer days){
        ResponseGenerator generator = new ResponseGenerator();
        return generator.vacationResponse(salary, days);
    }
}
