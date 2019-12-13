package com.strafeup.task2.part2.entity;

import java.util.Comparator;

public class BookComparator implements Comparator {
    @Override
    public int compare(Object o1, Object o2) {
        Book b1 = (Book) o1;
        Book b2 = (Book) o2;
        return b1.getPublisher().getName().compareTo(b2.getPublisher().getName());
    }
}
