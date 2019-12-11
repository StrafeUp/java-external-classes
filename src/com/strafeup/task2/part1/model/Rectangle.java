package com.strafeup.task2.part1.model;

public class Rectangle extends AbstractShape {
    private double height;
    private double width;

    Rectangle(String colorShape, double height, double width) {
        super(colorShape);
        this.height = height;
        this.width = width;
        this.shapeType = ShapeType.RECTANGLE;
    }

    @Override
    public double calcArea() {
        return height * width;
    }

    @Override
    public String toString() {
        return super.toString() + " width= " + width + " height= " + height;
    }
}
