package com.example.BMI.entity;

public class BMI {

    private double height;
    private double mass;
    private String solution;
    private String information;

    public BMI(){}

    public BMI(double height, double mass) {
        this.height = height;
        this.mass = mass;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getMass() {
        return mass;
    }

    public void setMass(double mass) {
        this.mass = mass;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }

    @Override
    public String toString() {
        return "BMI{" +
                "height=" + height +
                ", mass=" + mass +
                ", solution='" + solution + '\'' +
                ", information='" + information + '\'' +
                '}';
    }
}
