package com.strafeup.task2.part2.controller;

import com.strafeup.task2.part2.entity.*;
import com.strafeup.task2.part2.view.ConsolePrinter;
import com.strafeup.task2.part2.view.InputData;

import java.util.Arrays;

public class BookController {
    private BookPool bookPool;

    public BookController() {
        this.bookPool = new BookPool(10);
        ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooks()));
    }


    public void start() {

        boolean exit = false;

        while (!exit) {
            System.out.println("Enter command");
            System.out.println("1 - find books by author");
            System.out.println("2 - find books by publisher");
            System.out.println("3 - find books published after year");
            System.out.println("4 - sort books by publisher");
            System.out.println("5 - exit");

            int choice = Integer.parseInt(InputData.getInput());

            switch (choice) {
                case 1:
                    System.out.println("Enter name of author");
                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooksByAuthor(InputData.getInput())));
                    break;
                case 2:
                    System.out.println("Enter name of publisher");
                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooksByPublisher(InputData.getInput())));
                    break;
                case 3:
                    System.out.println("Enter year");
                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooksPublishedAfterCertainYear(Integer.parseInt(InputData.getInput()))));
                    break;
                case 4:

                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.sortByComparator(new BookComparator())));
                    break;
                case 5:
                    exit = true;
                    return;

            }
        }
    }

}
