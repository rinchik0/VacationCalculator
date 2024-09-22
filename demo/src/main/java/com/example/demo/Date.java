package com.example.demo;

public class Date {
    int day, month, year;

    Date(int Day, int Month, int Year){
        day = Day;
        month = Month;
        year = Year;
        normalize();
    }
    Date(String stringDate){
        if (stringDate.matches("^\\d{2}.\\d{2}.\\d{4}")) {
            String[] elements = stringDate.split("\\.");
            day = Integer.parseInt(elements[0]);
            month = Integer.parseInt(elements[1]);
            year = Integer.parseInt(elements[2]);
            normalize();
        } else
            day = month = year = 0;
    }

    private void normalize(){
        switch(month){
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12: {
                if (day > 31){
                    month += (day / 31);
                    day = day % 31;
                }
            } break;
            case 2:{
                if (year % 4 == 0){
                    if (day > 29){
                        month += (day / 29);
                        day = day % 29;
                    }
                }
                else {
                    if (day > 28){
                        month += (day / 28);
                        day = day % 28;
                    }
                }
            } break;
            case 4:
            case 6:
            case 9:
            case 11: {
                if (day > 30){
                    month += (day / 30);
                    day = day % 30;
                }
            } break;
        }
        if (month > 12){
            year += (month / 12);
            month = month % 12;
        }
    }
    public Date later(int increaseDays){
        return new Date(day + increaseDays, month, year);
    }
    public boolean isNull(){
        return day == 0 && month == 0 && year == 0;
    }
    public boolean isBetween(Date first, Date second){
        boolean currentLaterFirst = year > first.year || year == first.year && month > first.month ||
                year == first.year && month == first.month && day >= first.day;
        boolean currentEarlierSecond = !(year > second.year || year == second.year && month > second.month ||
                year == second.year && month == second.month && day >= second.day);
        return currentLaterFirst && currentEarlierSecond;
    }
}
