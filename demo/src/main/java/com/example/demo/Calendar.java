package com.example.demo;

import java.util.ArrayList;

public class Calendar {
    private ArrayList<Date> holidays;
    private static final int currentYear = 2024;

    Calendar(){
        holidays = new ArrayList<Date>();
        holidays.add(new Date(1, 1, currentYear));
        holidays.add(new Date(23, 2, currentYear));
        holidays.add(new Date(8, 3, currentYear));
        holidays.add(new Date(1, 5, currentYear));
        holidays.add(new Date(9, 5, currentYear));
        holidays.add(new Date(12, 6, currentYear));
        holidays.add(new Date(4, 11, currentYear));
        holidays.add(new Date(31, 12, currentYear));
        //Можно добавить еще переменных для праздников
    }
    public int getPaidDaysForPeriod(Date start, int paidDays){
        Date end = start.later(paidDays);
        for (Date holiday: holidays){
            if (holiday.isBetween(start, end)){
                paidDays--;
            }
        }
        return paidDays;
    }
}
