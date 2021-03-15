package com.example.BMI.repository;

public interface KcalRepository {

    double count(int age, int height, double mass, double lifestyle, String gender);

    double lifestyle(String lifestyle);

    String convert(double solution);
}
