package com.infoshareacademy.searchengine.cdibeans;

import com.infoshareacademy.searchengine.domain.Gender;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class MaxPulseBean implements MaxPulse {


    @Override
    public double calculatePulse(int age, Gender gender) {
        if(gender == Gender.MAN) {
            double pulse = 202 - (0.55 * age);
            return pulse;
        } else {
            double pulse = 216 - (1.09 * age);
            return pulse;
        }
    }

}
