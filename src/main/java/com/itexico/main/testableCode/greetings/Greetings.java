package com.itexico.main.testableCode.greetings;

import java.time.LocalTime;

public class Greetings {
    public String sayHello() {
        LocalTime now = LocalTime.now();
        if (now.isAfter(LocalTime.of(0, 0)) && now.isBefore(LocalTime.of(6, 0)))
            return "Good night";
        if (now.isAfter(LocalTime.of(6, 0)) && now.isBefore(LocalTime.of(12, 0)))
            return "Good morning";
        if (now.isAfter(LocalTime.of(12, 0)) && now.isBefore(LocalTime.of(19, 0)))
            return "Good afternoon";
        return "Good evening";
    }
}