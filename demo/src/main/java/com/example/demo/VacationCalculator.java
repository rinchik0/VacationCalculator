package com.example.demo;

public class VacationCalculator {
    private double vacation, averageDailyEarnings;
    private int paidDays;
    private static final double NDFL = 0.13;

    VacationCalculator(double salary, int days){
        if (days >= 0)
            paidDays = days;
        if (salary >= 0)
            averageDailyEarnings = salary /  29.3;
    }

    VacationCalculator(double salary, int days, Date beginDate){
        Calendar calendar = new Calendar();
        if (days >= 0)
            paidDays = calendar.getPaidDaysForPeriod(beginDate, days);
        if (salary >= 0)
            averageDailyEarnings = salary /  29.3;
    }

    public double calculate(){
        vacation = averageDailyEarnings * paidDays;
        return (double) Math.round(vacation * 100) / 100;
    }

    public double calculateWithNDFL() {
        return (double) Math.round(vacation * (1 - NDFL) * 100) / 100;
    }
}
