package com.example.BMI.service;

import com.example.BMI.repository.KcalRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class KcalService implements KcalRepository {

    public String customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }

    @Override
    public double count(int age, int height, double mass, double lifestyle, String gender) {
        if (gender.equals("male")) {
            return (66.5 + (13.7 * mass) + (5 * height) - (6.8 * age)) * lifestyle;
        } else {
            return (65.5 + (9.6 * mass) + (1.85 * height) - (4.7 * age)) * lifestyle;
        }
    }

    @Override
    public double lifestyle(String lifestyleS) {
        if (lifestyleS.equals("lying or sedentary lifestyle, lack of physical activity")) {
            return 1.0;
        } else if (lifestyleS.equals("sedentary work, low-level physical activity")) {
            return 1.2;
        } else if (lifestyleS.equals("non-physical work, training twice a week")) {
            return 1.4;
        } else if (lifestyleS.equals("light physical work, training 3-4 times a week")) {
            return 1.6;
        } else if (lifestyleS.equals("physical work, training 5 times a week")) {
            return 1.8;
        } else if (lifestyleS.equals("hard physical work, daily training")) {
            return 2.0;
        } else {
            return 0;
        }
    }

    @Override
    public String convert(double solution) {
        String output = customFormat("####", solution);
        return output;
    }
}
