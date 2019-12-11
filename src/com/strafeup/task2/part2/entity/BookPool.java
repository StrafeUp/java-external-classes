package com.strafeup.task2.part2.entity;


import java.util.Arrays;
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
                    new Publisher("Publisher" + i), (2009 + random.nextInt(10)),
                    (200 + random.nextInt(100)), random.nextDouble());
        }
    }

    @Override
    public String toString() {
        return "BookPool{" +
                "innerArr=" + Arrays.toString(innerArr) +
                '}';
    }

}
