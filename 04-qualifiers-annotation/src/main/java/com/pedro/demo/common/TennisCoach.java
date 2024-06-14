package com.pedro.demo.common;

import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in Tennis! ";
    }
}
