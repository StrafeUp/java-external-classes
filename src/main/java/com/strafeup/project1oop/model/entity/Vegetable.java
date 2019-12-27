package com.strafeup.project1oop.model.entity;


/**
 * Basic entity
 */
public class Vegetable {
    private String name;
    private VegetableColorCategory vegetableColorCategory;
    private RipenessPercentage ripenessPercentage;
    private double calories;
    private double weight;

    public Vegetable(String name, VegetableColorCategory vegetableColorCategory, RipenessPercentage ripenessPercentage, double calories, double weight) {
        this.name = name;
        this.vegetableColorCategory = vegetableColorCategory;
        this.ripenessPercentage = ripenessPercentage;
        this.calories = calories;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public VegetableColorCategory getVegetableColorCategory() {
        return vegetableColorCategory;
    }

    public void setVegetableColorCategory(VegetableColorCategory vegetableColorCategory) {
        this.vegetableColorCategory = vegetableColorCategory;
    }

    public RipenessPercentage getRipenessPercentage() {
        return ripenessPercentage;
    }

    public void setRipenessPercentage(RipenessPercentage ripenessPercentage) {
        this.ripenessPercentage = ripenessPercentage;
    }

    public double getCalories() {
        return calories;
    }

    public void setCalories(double calories) {
        this.calories = calories;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "\n" + name + ", color category: " + vegetableColorCategory + ", ripeness: " + ripenessPercentage.getPercentage() +
                "%, cal: " + calories + ", " + weight + "g,\n";
    }
}
