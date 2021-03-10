package com.example.BMI.service;

import com.example.BMI.repository.BMIRepository;
import org.springframework.stereotype.Service;

import java.text.DecimalFormat;

@Service
public class BMIService implements BMIRepository {

    public String customFormat(String pattern, double value) {
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }

    @Override
    public double count(double height, double mass) {
        double solution = mass / (Math.pow(height, 2));
        return solution;
    }

    @Override
    public String info(double solution) {
        if (solution < 18.5) {
            return "Underweight";
        } else if (solution == 18.5 || solution < 24.9) {
            return "Correct body weight";
        } else if (solution == 25 || solution < 29.9) {
            return "Overweight";
        } else if (solution == 30 || solution < 34.9) {
            return "1st degree obesity";
        } else if (solution == 35 || solution < 39.9) {
            return "2nd degree obesity";
        } else if (solution > 40) {
            return "3rd degree obesity";
        } else {
            return "";
        }
    }

    @Override
    public String convert(double solution) {
        String output = customFormat("###.##", solution);
        return output;
    }
}
