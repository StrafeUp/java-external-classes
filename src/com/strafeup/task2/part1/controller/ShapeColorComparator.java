package com.strafeup.task2.part1.controller;

import com.strafeup.task2.part1.model.AbstractShape;

import java.util.Comparator;

public class ShapeColorComparator implements Comparator<AbstractShape> {
    @Override
    public int compare(AbstractShape o1, AbstractShape o2) {
        return o1.getColorShape().compareTo(o2.getColorShape());
    }
}
