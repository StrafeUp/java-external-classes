package com.strafeup.task2.part1.model;

public class Triangle extends AbstractShape {
    private double a, b, c;

    @Override
    public double calcArea() {
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    Triangle(String colorShape, double a, double b, double c) {
        super(colorShape);
        this.a = a;
        this.b = b;
        this.c = c;
    }

    @Override
    public String toString() {
        return super.toString() +
                "a= " + a +
                ", b= " + b +
                ", c= " + c;
    }
}
