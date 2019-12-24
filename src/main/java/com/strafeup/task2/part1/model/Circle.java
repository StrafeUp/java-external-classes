package com.strafeup.task2.part1.model;

public class Circle extends AbstractShape {

    private double radius;

    Circle(String colorShape, double radius) {
        super(colorShape);
        this.radius = radius;

    }

    @Override
    public double calcArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return super.toString() + " radius= " + radius;
    }
}
