package com.example.BMI.entity;

public class Kcal {

    private int age;
    private int height;
    private double mass;
    private double lifestyle;
    private String lifestyleS;
    private String gender;
    private String solution;

    public Kcal(){}

    public Kcal(int age, int height, double mass, String lifestyleS, String gender) {
        this.age = age;
        this.height = height;
        this.mass = mass;
        this.lifestyleS = lifestyleS;
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public double getLifestyle() {
        return lifestyle;
    }

    public void setLifestyle(double lifestyle) {
        this.lifestyle = lifestyle;
    }

    public String getLifestyleS() {
        return lifestyleS;
    }

    public void setLifestyleS(String lifestyleS) {
        this.lifestyleS = lifestyleS;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    @Override
    public String toString() {
        return "Kcal{" +
                "age=" + age +
                ", height=" + height +
                ", mass=" + mass +
                ", lifestyle=" + lifestyle +
                ", solution=" + solution +
                '}';
    }
}
