package com.example.BMI.repository;

public interface BMIRepository {

    double count(double height, double mass);

    String info(double solution);

    String convert(double solution);
}
