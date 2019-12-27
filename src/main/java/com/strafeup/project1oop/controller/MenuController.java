package com.strafeup.project1oop.controller;

import com.strafeup.project1oop.model.SaladModel;
import com.strafeup.project1oop.model.entity.RipenessPercentage;
import com.strafeup.project1oop.model.entity.Vegetable;
import com.strafeup.project1oop.model.entity.VegetableColorCategory;
import com.strafeup.project1oop.view.ConsolePrinter;
import com.strafeup.project1oop.view.UserInput;

import java.util.Arrays;

/**
 * Controller for menu of the app
 */
public class MenuController {
    public void start() {
        menu();
    }

    /**
     * Start menu
     */
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

    /**
     * @param saladModel to look in for
     */
    private void findVegetablesInRange(SaladModel saladModel) {
        if (!checkIfSaladEmpty(saladModel)) {
            ConsolePrinter.print("Enter lower bound of calories");
            double lowerBound = UserInput.getDoubleInput();
            ConsolePrinter.print("Enter upper bound of calories");
            double upperBound = UserInput.getDoubleInput();
            saladModel.findByCalories(lowerBound, upperBound);
        }
    }
    /**
     * @param saladModel to look in for
     */
    public void countTotalCalories(SaladModel saladModel) {
        if (!checkIfSaladEmpty(saladModel)) {
            ConsolePrinter.print("The total calories in salad is " + saladModel.countTotalCaloriesInSalad());
        }
    }
    /**
     * @param saladModel to look in for
     */
    private void sortByParameter(SaladModel saladModel) {
        if (!checkIfSaladEmpty(saladModel)) {
            ConsolePrinter.print("Available parameters: Name, Color, Calories, Weight\nEnter parameter:");
            saladModel.setSaladVegetables(saladModel.sortBy(UserInput.getWord()));
        }
    }

    /**
     * @return new salad with inputted vegetable characteristics
     */
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
    /**
     * @return vegetable with provided inputs
     */
    private Vegetable getVegetable(int i) {
        return new Vegetable(getName(i), getColorCategory(), getRipenessPercentage(), getCalories(), getWeight());
    }

    public boolean checkIfSaladEmpty(SaladModel saladModel) {
        if (saladModel.getIngredientCount() <= 0) {
            ConsolePrinter.print("Salad is empty");
            return true;
        }
        return false;
    }

    /**
     * @param i ordinal number of vegetable
     * @return name of vegetable
     */
    private String getName(int i) {
        ConsolePrinter.print("Enter name of vegetable number " + (i + 1));
        return UserInput.getWord();
    }

    /**
     * @return getter from user
     */
    private VegetableColorCategory getColorCategory() {
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
        return vegetableColorCategory;
    }
    /**
     * @return getter from user
     */
    private RipenessPercentage getRipenessPercentage() {
        ConsolePrinter.print("Choose ripeness percentage");
        ConsolePrinter.print(Arrays.toString(RipenessPercentage.values()));
        RipenessPercentage ripenessPercentage;

        while (true) {
            try {
                ripenessPercentage = RipenessPercentage.valueOf(UserInput.getWord().toUpperCase());
                break;
            } catch (IllegalArgumentException ignored) {
                ConsolePrinter.print("Unrecognized category");
            }
        }
        return ripenessPercentage;
    }
    /**
     * @return getter from user
     */
    private double getCalories() {
        double calories = 0;
        while (calories <= 0) {
            ConsolePrinter.print("Enter vegetable calories, can't be negative");
            calories = UserInput.getDoubleInput();
        }
        return calories;
    }
    /**
     * @return getter from user
     */
    private double getWeight() {
        double weight = 0;
        while (weight <= 0) {
            ConsolePrinter.print("Enter vegetable weight");
            weight = UserInput.getDoubleInput();
        }
        return weight;
    }
}
