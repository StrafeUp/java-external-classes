package com.strafeup.task2.part1.controller;

import com.strafeup.task2.part1.model.*;
import com.strafeup.task2.part1.view.AbstractPrinter;

import java.util.Arrays;

public class ShapeController {

    private AbstractPrinter printer;
    private AbstractShape[] internalArray;

    public ShapeController(AbstractPrinter printer) {
        ShapePool shapePool = new ShapePool(10);
        this.internalArray = shapePool.getShapeArray();
        this.printer = printer;
    }

    public void showArray() {
        for (AbstractShape abstractShape : internalArray) {
            printer.print(abstractShape);
        }
    }


}
