package com.strafeup.task3.part1.controller.comparators;

import com.strafeup.task3.part1.model.Toy;

import java.util.Comparator;

public class CompareToysByPrice implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return (int) (o1.getPrice() - o2.getPrice());
    }
}
