package com.strafeup.task2.part2.entity;

import java.util.Comparator;

public class BookComparator implements Comparator<Book> {
    @Override
    public int compare(Book o1, Book o2) {
        return o1.getPublisher().getName().compareTo(o2.getPublisher().getName());
    }
}
