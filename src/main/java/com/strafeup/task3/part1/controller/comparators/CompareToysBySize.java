package com.strafeup.task3.part1.controller.comparators;

import com.strafeup.task3.part1.model.Toy;

import java.util.Comparator;

public class CompareToysBySize implements Comparator<Toy> {
    @Override
    public int compare(Toy o1, Toy o2) {
        return (int) ((o1.getDepth() * o1.getHeigth() * o1.getWidth()) - (o2.getDepth() * o2.getHeigth() * o2.getWidth()));
    }
}
