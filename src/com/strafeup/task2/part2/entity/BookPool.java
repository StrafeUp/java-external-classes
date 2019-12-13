package com.strafeup.task2.part2.entity;

import com.strafeup.task2.part2.view.ConsolePrinter;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class BookPool {

    private Book[] innerArr;

    public Book[] getBooks() {
        return innerArr;
    }

    public BookPool(int size) {
        this.innerArr = new Book[size];
        for (int i = 0; i < size; i++) {
            Random random = new Random();
            innerArr[i] = new Book("" + i, new Author("Author" + random.nextInt(3)),
                    new Publisher("Publisher" + random.nextInt(3)), (2009 + random.nextInt(10)),
                    (200 + random.nextInt(100)), random.nextDouble());
        }
    }

    public Book[] getBooksByAuthor(String author) {
        Book[] newArr = new Book[innerArr.length];
        int i = 0;
        Author toFind = new Author(author);
        for (Book book : innerArr) {
            if (book.getAuthor().equals(toFind)) {
                newArr[i] = book;
                i++;
            }
        }
        if(newArr.length == 0){
            ConsolePrinter.print("Not found");
        }
        return newArr;
    }
    public Book[] getBooksByPublisher(String publisher){
        Book[] newArr = new Book[innerArr.length];
        int i = 0;
        Publisher toFind = new Publisher(publisher);
        for (Book book : innerArr) {
            if (book.getPublisher().equals(toFind)) {
                newArr[i] = book;
                i++;
            }
        }
        if(newArr.length == 0){
            ConsolePrinter.print("Not found");
        }
        return newArr;
    }
    public Book[] getBooksPublishedAfterCertainYear(int year) {
        Book[] newArr = new Book[innerArr.length];
        int i = 0;
        for (Book book : innerArr) {
            if (book.getYear() > year) {
                newArr[i] = book;
                i++;
            }
        }
        if(newArr.length == 0){
            ConsolePrinter.print("Not found");
        }
        return newArr;
    }

    public Book[] sortByComparator(Comparator comparator){
        Book[] newArr = Arrays.copyOf(innerArr, innerArr.length);
        Arrays.sort(newArr, comparator);
        return newArr;
    }

    @Override
    public String toString() {
        return "BookPool{" +
                "innerArr=" + Arrays.toString(innerArr) +
                '}';
    }

}
