package com.springcloud.demo.controller;

import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Map;

public class TestBreak {
    public static void main(String[] args) {
        LocalDateTime ldt = LocalDateTime.now();

        System.out.println(ldt.getYear());
        System.out.println(ldt.getMonthValue());
        System.out.println(ldt.getDayOfMonth());
        System.out.println(ldt.getMinute());

        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar.getActualMaximum(Calendar.DAY_OF_MONTH));

        try {
            throw new RuntimeException("123");
        } catch (RuntimeException e) {
            System.out.println("Runtime");
            e.printStackTrace();
        } catch (Exception e){
            System.out.println("Exception");
            e.printStackTrace();
        }


    }
}
