package com.strafeup.task2.part1.model;

public class Circle extends AbstractShape {

    private double radius;

    public Circle(String colorShape, double radius) {
        super(colorShape);
        this.radius = radius;
        this.shapeType = ShapeType.CIRCLE;
    }

    @Override
    public double calcArea() {
        return Math.pow(radius, 2) * Math.PI;
    }

    @Override
    public void draw() {
        System.out.printf("%s; area=%.2f\n", this, calcArea());
    }

    @Override
    public String toString() {
        return super.toString() + " radius= " + radius;
    }
}
