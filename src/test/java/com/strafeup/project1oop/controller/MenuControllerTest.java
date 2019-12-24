package com.strafeup.project1oop.controller;

import com.strafeup.project1oop.model.SaladModel;
import com.strafeup.project1oop.model.entity.Vegetable;
import com.strafeup.project1oop.model.entity.VegetableColorCategory;
import org.junit.Test;

import static org.junit.Assert.*;

public class MenuControllerTest {

    @Test
    public void checkIfSaladEmpty() {
        SaladModel saladModel = new SaladModel(0);
        MenuController mainController = new MenuController();
        assertTrue(mainController.checkIfSaladEmpty(saladModel));
    }

    @Test
    public void countTotalCalories() {
        SaladModel saladModel = new SaladModel(0);
        assertEquals(0, saladModel.countTotalCaloriesInSalad(), 0.01);
    }

    @Test
    public void checkSaladAdd() {
        SaladModel saladModel = new SaladModel(2);
        Vegetable[] vegetables = new Vegetable[]{
                new Vegetable("Apple", VegetableColorCategory.RED, 100, 100),
                new Vegetable("Banana", VegetableColorCategory.YELLOW, 150, 100)
        };
        saladModel.addVegetables(vegetables);

        assertEquals(2, saladModel.getIngredientCount());
    }

    @Test
    public void checkSortByName() {
        SaladModel saladModel = new SaladModel(3);
        Vegetable[] vegetables = new Vegetable[]{
                new Vegetable("Banana", VegetableColorCategory.YELLOW, 150, 100),
                new Vegetable("Cucumber", VegetableColorCategory.GREEN, 30, 100),
                new Vegetable("Apple", VegetableColorCategory.RED, 100, 100),

        };
        saladModel.addVegetables(vegetables);

        assertArrayEquals(new Vegetable[]{new Vegetable("Apple", VegetableColorCategory.RED, 100, 100),
                new Vegetable("Banana", VegetableColorCategory.YELLOW, 150, 100),
                new Vegetable("Cucumber", VegetableColorCategory.GREEN, 30, 100)}, saladModel.sortBy("name"));
    }

    @Test
    public void checkSortByColorCategory() {
        SaladModel saladModel = new SaladModel(3);
        Vegetable[] vegetables = new Vegetable[]{
                new Vegetable("Banana", VegetableColorCategory.YELLOW, 150, 100),
                new Vegetable("Cucumber", VegetableColorCategory.GREEN, 30, 100),
                new Vegetable("Apple", VegetableColorCategory.RED, 100, 100),

        };
        saladModel.addVegetables(vegetables);

        assertArrayEquals(new Vegetable[]{new Vegetable("Apple", VegetableColorCategory.RED, 100, 100),
                new Vegetable("Cucumber", VegetableColorCategory.GREEN, 30, 100),

                new Vegetable("Banana", VegetableColorCategory.YELLOW, 150, 100),
        }, saladModel.sortBy("color"));
    }
}