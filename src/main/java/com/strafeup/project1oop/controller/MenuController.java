package com.strafeup.project1oop.controller;

import com.strafeup.project1oop.model.SaladModel;
import com.strafeup.project1oop.model.entity.Vegetable;
import com.strafeup.project1oop.model.entity.VegetableColorCategory;
import com.strafeup.project1oop.view.ConsolePrinter;
import com.strafeup.project1oop.view.UserInput;

import java.util.Arrays;

public class MenuController {
    public void start() {
        menu();
    }

    private void menu() {

        SaladModel saladModel = new SaladModel(0);
        while (true) {

            ConsolePrinter.print("Welcome to the Chef system, enter: \n" +
                    "1.To create salad \n" +
                    "2.Sort by parameter\n" +
                    "3.Get total calories of salad\n" +
                    "4.Find vegetables in salad between range\n" +
                    "5.To exit");

            switch (UserInput.getNumberInput()) {
                case 1: {
                    saladModel = createSalad();
                    ConsolePrinter.printSaladInfo(saladModel.getSalad());
                    break;
                }
                case 2: {
                    sortByParameter(saladModel);
                    ConsolePrinter.printSaladInfo(saladModel.getSalad());
                    break;
                }
                case 3:
                    countTotalCalories(saladModel);
                    ConsolePrinter.printSaladInfo(saladModel.getSalad());
                    break;
                case 4:
                    findVegetablesInRange(saladModel);
                    break;
                case 5:
                    return;
                default:
                    ConsolePrinter.print("Unrecognized command");
            }
        }
    }

    private void findVegetablesInRange(SaladModel saladModel) {
        if (!checkIfSaladEmpty(saladModel)) {
            ConsolePrinter.print("Enter lower bound of calories");
            double lowerBound = UserInput.getDoubleInput();
            ConsolePrinter.print("Enter upper bound of calories");
            double upperBound = UserInput.getDoubleInput();
            saladModel.findByCalories(lowerBound, upperBound);
        }
    }

    public void countTotalCalories(SaladModel saladModel) {
        if (!checkIfSaladEmpty(saladModel)) {
            ConsolePrinter.print("The total calories in salad is " + saladModel.countTotalCaloriesInSalad());
        }
    }

    private void sortByParameter(SaladModel saladModel) {
        if (!checkIfSaladEmpty(saladModel)) {
            ConsolePrinter.print("Available parameters: Name, Color, Calories, Weight\nEnter parameter:");
            saladModel.setSaladVegetables(saladModel.sortBy(UserInput.getWord()));
        }
    }

    private SaladModel createSalad() {
        ConsolePrinter.print("Enter number of ingredients");
        int ingredientCount = UserInput.getNumberInput();

        SaladModel saladModel = new SaladModel(ingredientCount);
        Vegetable[] vegetables = new Vegetable[ingredientCount];


        for (int i = 0; i < ingredientCount; i++) {
            vegetables[i] = getVegetable(i);
        }

        saladModel.addVegetables(vegetables);
        return saladModel;
    }

    private Vegetable getVegetable(int i) {
        ConsolePrinter.print("Enter name of vegetable number " + (i + 1));
        String name = UserInput.getWord();

        ConsolePrinter.print("Choose color category");
        ConsolePrinter.print(Arrays.toString(VegetableColorCategory.values()));
        VegetableColorCategory vegetableColorCategory;

        while (true) {
            try {
                vegetableColorCategory = VegetableColorCategory.valueOf(UserInput.getWord().toUpperCase());
                break;
            } catch (IllegalArgumentException ignored) {
                ConsolePrinter.print("Unrecognized category");
            }
        }

        double calories = 0;
        while (calories <= 0) {
            ConsolePrinter.print("Enter vegetable calories, can't be negative");
            calories = UserInput.getDoubleInput();
        }

        double weight = 0;
        while (weight <= 0) {
            ConsolePrinter.print("Enter vegetable weight");
            weight = UserInput.getDoubleInput();
        }

        return new Vegetable(name, vegetableColorCategory, calories, weight);
    }

    public boolean checkIfSaladEmpty(SaladModel saladModel) {
        if (saladModel.getIngredientCount() <= 0) {
            ConsolePrinter.print("Salad is empty");
            return true;
        }
        return false;
    }
}
