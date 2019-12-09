package com.strafeup.task2.model;

public class Rectangle extends AbstractShape {
    private double height;
    private double width;

    public Rectangle(String colorShape, double height, double width) {
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
    public void draw() {
        System.out.printf("%s; area=%.2f\n", this, calcArea());
    }

    @Override
    public String toString() {
        return super.toString() + " width= " + width + " height= " + height;
    }
}
