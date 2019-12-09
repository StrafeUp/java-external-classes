package com.strafeup.task2;

import com.strafeup.task2.controller.ShapeController;
import com.strafeup.task2.view.ConsolePrinter;

public class Main {

    public static void main(String[] args) {

        ConsolePrinter consolePrinter = new ConsolePrinter();
        ShapeController shapeController = new ShapeController(consolePrinter);
        shapeController.initShapes();
        shapeController.showArray();

    }
}
