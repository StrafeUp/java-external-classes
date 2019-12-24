package com.strafeup.project1oop.model;

import com.strafeup.project1oop.model.entity.Salad;
import com.strafeup.project1oop.model.entity.Vegetable;
import com.strafeup.project1oop.view.ConsolePrinter;

import java.util.Arrays;

public class SaladModel {
    private Salad salad;
    private int ingredientCount;

    public SaladModel(int ingredientCount) {
        this.ingredientCount = ingredientCount;
        this.salad = new Salad(ingredientCount);
    }

    public void addVegetables(Vegetable... vegetables) {
        if (vegetables.length > this.ingredientCount) {
            ConsolePrinter.print("Provided list of vegetables is longer than salad is capable of, putting upto limits");
        }
        for (int i = 0; i < ingredientCount; i++) {
            this.salad.getVegetables()[i] = vegetables[i];
        }
        salad.setTotalCalories((int) countTotalCaloriesInSalad());
    }

    public void sortBy(String parameter) {
        while (true) {
            switch (parameter.toLowerCase()) {
                case "calories":
                    Arrays.sort(this.salad.getVegetables(), (o1, o2) -> (int) (o1.getCalories() - o2.getCalories()));
                    return;
                case "color":
                    Arrays.sort(this.salad.getVegetables(), (o1, o2) -> o1.getVegetableColorCategory().compareTo(o2.getVegetableColorCategory()));
                    return;
                case "name":
                    Arrays.sort(this.salad.getVegetables(), (o1, o2) -> o1.getName().compareTo(o2.getName()));
                    return;
                case "weight":
                    Arrays.sort(this.salad.getVegetables(), (o1, o2) -> (int) (o1.getWeight() - o2.getWeight()));
                    return;
                default:
                    ConsolePrinter.print("Parameter unrecognized");
                    break;
            }
        }
    }

    public void findByCalories(double lowerBound, double upperBound) {
        for (Vegetable veg : this.salad.getVegetables()) {
            if (veg.getCalories() < upperBound && veg.getCalories() > lowerBound) {
                ConsolePrinter.print(veg.getName() + " is in range if this salad");
            }
        }
    }

    public double countTotalCaloriesInSalad() {
        double sum = 0;
        for (Vegetable vegetable : this.salad.getVegetables()) {
            sum += vegetable.getCalories();
        }
        return sum;
    }

    public int getIngredientCount() {
        return ingredientCount;
    }

    public Salad getSalad() {
        return salad;
    }
}
