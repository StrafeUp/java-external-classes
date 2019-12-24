package com.strafeup.task2.part1;

import com.strafeup.task2.part1.controller.ShapeController;
import com.strafeup.task2.part1.view.ConsolePrinter;

public class Main {

    public static void main(String[] args) {

        ConsolePrinter consolePrinter = new ConsolePrinter();
        ShapeController shapeController = new ShapeController(consolePrinter);
        shapeController.showArray();
        System.out.println();
        shapeController.showArray();

    }
}
