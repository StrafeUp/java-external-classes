package com.strafeup.task2.controller;


import com.strafeup.task2.model.AbstractShape;

import java.util.Comparator;

public class ShapeAreaComparator implements Comparator<AbstractShape> {
    @Override
    public int compare(AbstractShape o1, AbstractShape o2) {
        return (int)(o1.calcArea() - o2.calcArea());
    }
}
