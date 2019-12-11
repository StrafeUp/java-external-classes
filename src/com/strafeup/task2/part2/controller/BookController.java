package com.strafeup.task2.part2.controller;

import com.strafeup.task2.part2.entity.*;
import com.strafeup.task2.part2.view.ConsolePrinter;

import java.util.Arrays;
import java.util.Scanner;

public class BookController {
    private BookPool bookPool;
    private ConsolePrinter view;

    public BookController(ConsolePrinter view) {
        this.bookPool = new BookPool(10);
        this.view = view;
        view.print(bookPool.getBooks());
    }

    private Book[] getBooksByAuthor(String author) {
        Book[] newArr = new Book[bookPool.getBooks().length];
        int i = 0;
        Author toFind = new Author(author);
        for (Book book : bookPool.getBooks()) {
            if (book.getAuthor().equals(toFind)) {
                newArr[i] = book;
                i++;
            }else {
                System.out.println("Not found");
                return newArr;
            }
        }
        return newArr;
    }
    private Book[] getBooksByPublisher(String publisher){
        Book[] newArr = new Book[bookPool.getBooks().length];
        int i = 0;
        Publisher toFind = new Publisher(publisher);
        for (Book book : bookPool.getBooks()) {
            if (book.getPublisher().equals(toFind)) {
                newArr[i] = book;
                i++;
            }else {
                System.out.println("Not found");
                return newArr;
            }
        }
        return newArr;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Enter command");
            System.out.println("1 - find books by author");
            System.out.println("2 - find books by publisher");
            System.out.println("3 - find books published after year");
            System.out.println("4 - sort books by publisher");
            System.out.println("5 - exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter name of author");
                    String author = scanner.next();
                    view.print(getBooksByAuthor(author));
                    break;
                case 2:
                    System.out.println("Enter name of publisher");
                    String publisher = scanner.next();
                    view.print(getBooksByPublisher(publisher));
                    break;
                case 3:
                    System.out.println("Enter year");
                    int year = scanner.nextInt();
                    view.print(getBooksPublishedAfterCertainYear(year));
                    break;
                case 4:
                    Arrays.sort(bookPool.getBooks(), new BookComparator());
                    view.print(bookPool.getBooks());
                    break;
                case 5: exit = true;
                    return;

            }
        }
    }

    private Book[] getBooksPublishedAfterCertainYear(int year) {
        Book[] newArr = new Book[bookPool.getBooks().length];
        int i = 0;
        for (Book book : bookPool.getBooks()) {
            if (book.getYear() > year) {
                newArr[i] = book;
                i++;
            }else {
                System.out.println("Not found");
                return newArr;
            }
        }
        return newArr;
    }
}
