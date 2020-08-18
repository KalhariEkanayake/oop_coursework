package com.kalhari.onlinegym.spring.date;

import java.io.Serializable;
import java.util.Calendar;

public class Date implements Serializable {
    private int day;
    private int month;
    private int year;

    public Date(){}

    public Date(int day,int month,int year) throws IllegalArgumentException {
        if (!isValid(day, month, year)) throw new IllegalArgumentException();
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return this.day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return this.month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return this.year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getDate() {
        return this.getDate();
    }

    public void setDate(int day,int month,int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    /**
     * Check if given year/month/day is valid
     * @param day
     * @param month
     * @param year
     * @return true if it is valid date
     */
    public static boolean isValid(int day, int month, int year) {
        if (year < 0) return false;
        if ((month < 1) || (month > 12)) return false;
        if ((day < 1) || (day > 31)) return false;
        switch (month) {
            case 1: return true;
            case 2: return (isLeap(year) ? day <= 29 : day <= 28);
            case 3: return true;
            case 4: return day < 31;
            case 5: return true;
            case 6: return day < 31;
            case 7: return true;
            case 8: return true;
            case 9: return day < 31;
            case 10: return true;
            case 11: return day < 31;
            default: return true;
        }
    }

    /**
     * Check given year is leap year
     * @param year
     * @return true if year is leap year
     */
    public static boolean isLeap(int year) {
        // using system library to do this, avoid re-invent the wheel
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.YEAR, year);
        return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
    }

    /* Returns a descriptive String in the form "DD/MM/YYYY" with leading zero */
    @Override
    public String toString() {
        // Use built-in function String.format() to form a formatted String
        return String.format("%02d-%02d-%4d", day, month, year);
        // Specifier "0" to print leading zeros
    }
}
