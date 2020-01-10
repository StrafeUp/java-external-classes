package com.strafeup.task5.part2.controller;

import com.strafeup.task5.part2.model.CollectionGenerator;
import com.strafeup.task5.part2.view.ConsolePrinter;
import com.strafeup.task5.part2.view.UserInput;

public class CollectionController {
    private CollectionGenerator collectionGenerator;

    public CollectionController() {
        collectionGenerator = new CollectionGenerator();
    }

    public void start() {
        menu();
    }

    private void showListAndSet() {
        StringBuilder sb = new StringBuilder();
        sb.append("List: ");
        for (Object o : collectionGenerator.getObjectList()) {
            sb.append(o.toString());
            sb.append(" ");
        }
        ConsolePrinter.print(sb.toString());

        sb = new StringBuilder();
        sb.append("Set: ");
        for (Object o : collectionGenerator.getObjectSet()) {
            sb.append(o.toString());
            sb.append(" ");
        }
        ConsolePrinter.print(sb.toString());
    }

    private void menu() {
        int menuInput;
        while (true) {
            ConsolePrinter.print("Welcome to collection generator\n 1. To generate collections\n 2. Show collections\n 5. Exit");
            menuInput = UserInput.getNumber();
            switch (menuInput) {
                case 1:
                    int number = UserInput.getNumber("Enter number of elements");
                    int lowerBound = UserInput.getNumber("Enter lower bound");
                    int upperBound = UserInput.getNumber("Enter upper bound");

                    collectionGenerator.generateList(number, lowerBound, upperBound);
                    collectionGenerator.generateSet(number, lowerBound, upperBound);
                    break;
                case 2:
                    showListAndSet();
                    break;
                case 5:
                    return;
            }
        }
    }
}
