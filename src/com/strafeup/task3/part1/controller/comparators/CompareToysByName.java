package com.strafeup.task3.part1.controller.comparators;

import com.strafeup.task3.part1.model.Toy;

import java.util.Comparator;

public class CompareToysByName implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
