package com.strafeup.project1oop.model.entity;

import java.util.Objects;

public class Vegetable {
    private String name;
    private VegetableColorCategory vegetableColorCategory;
    private double calories;
    private double weight;

    public Vegetable(String name, VegetableColorCategory vegetableColorCategory, double calories, double weight) {
        this.name = name;
        this.vegetableColorCategory = vegetableColorCategory;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Vegetable)) return false;
        Vegetable vegetable = (Vegetable) o;
        return Double.compare(vegetable.calories, calories) == 0 &&
                Double.compare(vegetable.weight, weight) == 0 &&
                Objects.equals(name, vegetable.name) &&
                vegetableColorCategory == vegetable.vegetableColorCategory;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vegetableColorCategory, calories, weight);
    }

    @Override
    public String toString() {
        return "\n" + name + ", color category: " + vegetableColorCategory +
                ", cal: " + calories + ", " + weight + "g,\n";
    }
}
