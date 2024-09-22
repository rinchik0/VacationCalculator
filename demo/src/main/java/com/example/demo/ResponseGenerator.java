package com.example.demo;

public class ResponseGenerator {
    public String vacationResponse(double salary, int days){
        return vacationResponse(salary, days, new Date(0,0,0));
    }
    public String vacationResponse(double salary, int days, Date beginDate){
        VacationCalculator calculator;
        if (beginDate.isNull()){
            calculator = new VacationCalculator(salary, days);
        }
        else {
            calculator = new VacationCalculator(salary, days, beginDate);
        }
        String response = "Full vacation for this salary and period will be: " + calculator.calculate()
                + " Vacation with NDFL: " + calculator.calculateWithNDFL();
        return response;
    }
}
