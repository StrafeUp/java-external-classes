package com.strafeup.task4.part2.controller;

import com.strafeup.task4.part2.entity.BookPool;
import com.strafeup.task4.part2.view.ConsolePrinter;
import com.strafeup.task4.part2.view.InputData;

public class BookController {
    private BookPool bookPool;

    public BookController() {
        this.bookPool = new BookPool(10);
        ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooks()));
    }


    public void start() {

        while (true) {
            ConsolePrinter.print("Enter command");
            ConsolePrinter.print("1 - find books by author");
            ConsolePrinter.print("2 - find books by publisher");
            ConsolePrinter.print("3 - find books published after year");
            ConsolePrinter.print("4 - sort books by publisher");
            ConsolePrinter.print("5 - exit");

            switch (Integer.parseInt(InputData.getInput())) {
                case 1:
                    ConsolePrinter.print("Enter name of author");
                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooksByAuthor(InputData.getInput())));
                    break;
                case 2:
                    ConsolePrinter.print("Enter name of publisher");
                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooksByPublisher(InputData.getInput())));
                    break;
                case 3:
                    ConsolePrinter.print("Enter year");
                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.getBooksPublishedAfterCertainYear(Integer.parseInt(InputData.getInput()))));
                    break;
                case 4:
                    ConsolePrinter.print(ConvertToString.convertArray(bookPool.sortByPublisher()));
                    break;
                case 5:
                    return;

            }
        }
    }

}
