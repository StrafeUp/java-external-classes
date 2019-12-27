package com.strafeup.project1oop.model.entity;


import java.util.Arrays;
import java.util.Objects;


/**
 * Basic grouping entity
 */
public class Salad {
    Vegetable[] vegetables;
    int ingredientCount = 0;
    int size;
    int totalCalories = 0;

    public Salad(int ingredientCount) {
        this.ingredientCount = ingredientCount;
        this.vegetables = new Vegetable[ingredientCount];
    }

    public Vegetable[] getVegetables() {
        return vegetables;
    }

    public void setVegetables(Vegetable[] vegetables) {
        this.vegetables = vegetables;
    }

    public int getIngredientCount() {
        return ingredientCount;
    }

    public void setIngredientCount(int ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotalCalories() {
        return totalCalories;
    }

    public void setTotalCalories(int totalCalories) {
        this.totalCalories = totalCalories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Salad)) return false;
        Salad salad = (Salad) o;
        return ingredientCount == salad.ingredientCount &&
                size == salad.size &&
                totalCalories == salad.totalCalories &&
                Arrays.equals(vegetables, salad.vegetables);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(ingredientCount, size, totalCalories);
        result = 31 * result + Arrays.hashCode(vegetables);
        return result;
    }

    @Override
    public String toString() {
        return "Salad of " + ingredientCount + ": " + Arrays.toString(vegetables) + "\ntotal calories: " + totalCalories;
    }
}
