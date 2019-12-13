package com.strafeup.task2.part1.model;

public abstract class AbstractShape implements Drawable {
    private String colorShape;


    AbstractShape(String colorShape) {
        this.colorShape = colorShape;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": colorShape= " + colorShape + ": area=" + calcArea();
    }

    public abstract double calcArea();

    public void draw() {
        System.out.printf("%s; area=%.2f ", this, calcArea());
    }

    public String getColorShape() {
        return colorShape;
    }
}

