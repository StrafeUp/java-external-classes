package com.strafeup.task2.part1.model;

import com.strafeup.task2.part1.controller.ShapeAreaComparator;
import com.strafeup.task2.part1.controller.ShapeColorComparator;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ShapePool {
    private AbstractShape[] innerArr;

    public AbstractShape[] getShapeArray() {
        return innerArr;
    }

    public ShapePool(int size) {
        this.innerArr = new AbstractShape[size];

        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int ind = random.nextInt(3);
            switch (ind) {
                case 0:
                    innerArr[i] = new Circle("Yellow", random.nextDouble());
                    break;
                case 1:
                    innerArr[i] = new Rectangle("Red", random.nextDouble(), random.nextDouble());
                    break;
                case 2:
                    innerArr[i] = new Triangle("Green", random.nextDouble() + 1, random.nextDouble() + 1, random.nextDouble() + 1);
                    break;
            }
        }
    }

    public double sumOfShapesArea() {
        double sum = 0;
        for (AbstractShape abstractShape : innerArr) {
            sum += abstractShape.calcArea();
        }
        return sum;
    }

    public double areaSumOfSameShapes(String type) {
        double sum = 0;
        for (AbstractShape abstractShape : innerArr) {
            if (abstractShape.getClass().getSimpleName().equalsIgnoreCase(type)) {
                sum += abstractShape.calcArea();
            }
        }
        return sum;
    }

    public void sortByAscArea() {
        Arrays.sort(innerArr, new ShapeAreaComparator());
    }

    public void sortByColor() {
        Arrays.sort(innerArr, new ShapeColorComparator());
    }
}
