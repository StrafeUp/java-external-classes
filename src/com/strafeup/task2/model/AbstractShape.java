package com.strafeup.task2.model;

public abstract class AbstractShape implements Drawable {
    private String colorShape;
    protected ShapeType shapeType;

    public AbstractShape(String colorShape) {
        this.colorShape = colorShape;
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() +
                ": colorShape= " + colorShape;
    }

    public String getColorShape() {
        return colorShape;
    }

    public void setColorShape(String colorShape) {
        this.colorShape = colorShape;
    }

    public abstract double calcArea();

    public ShapeType getShapeType() {
        return shapeType;
    }

}

