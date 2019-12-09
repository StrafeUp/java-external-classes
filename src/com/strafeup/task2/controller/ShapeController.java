package com.strafeup.task2.controller;

import com.strafeup.task2.model.*;
import com.strafeup.task2.view.AbstractPrinter;

import java.util.Arrays;

public class ShapeController {

    private AbstractPrinter printer;
    private AbstractShape[] internalArray;

    public ShapeController(AbstractPrinter printer) {
        this.printer = printer;
    }

    public void showArray() {
        for (AbstractShape abstractShape : internalArray) {
            printer.print(abstractShape);
        }
    }

    public double sumOfShapesArea() {
        double sum = 0;
        for (AbstractShape abstractShape : internalArray) {
            sum += abstractShape.calcArea();
        }
        return sum;
    }

    public double areaSumOfSameShapes(ShapeType shapeType) {
        double sum = 0;
        for (AbstractShape abstractShape : internalArray) {
            if (abstractShape.getShapeType() == shapeType) sum += abstractShape.calcArea();
        }
        return sum;
    }

    public void sortByAscArea() {
        Arrays.sort(internalArray, new ShapeAreaComparator());
    }

    public void sortByColor() {
        Arrays.sort(internalArray, new ShapeColorComparator());
    }

    public void initShapes(){

        AbstractShape rect = new Rectangle("Red", 2, 10);
        AbstractShape rect2 = new Rectangle("Red", 3, 4);
        AbstractShape rect3 = new Rectangle("Red", 6, 6);

        AbstractShape circle = new Circle("Green", 5.0);
        AbstractShape circle2 = new Circle("Green", 7.0);
        AbstractShape circle3 = new Circle("Green", 3.0);

        AbstractShape triangle = new Triangle("Yellow", 2, 2, 3);
        AbstractShape triangle2 = new Triangle("Yellow", 5, 2, 3);
        AbstractShape triangle3 = new Triangle("Yellow", 4, 2, 3);

        internalArray = new AbstractShape[]{rect, rect2, rect3, circle, circle2, circle3, triangle, triangle2, triangle3};

    }
}
