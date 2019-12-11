package com.strafeup.task2.part2;

import com.strafeup.task2.part2.controller.BookController;

import com.strafeup.task2.part2.view.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
        ConsolePrinter consolePrinter = new ConsolePrinter();
        BookController bookController = new BookController(consolePrinter);

        bookController.start();

    }
}
