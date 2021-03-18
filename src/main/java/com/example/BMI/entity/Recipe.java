package com.example.BMI.entity;

public class Recipe {

    private String category;
    private String name;
    private int id;

    public Recipe(){}

    public Recipe(String category, String name, int id) {
        this.category = category;
        this.name = name;
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "category='" + category + '\'' +
                ", name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
