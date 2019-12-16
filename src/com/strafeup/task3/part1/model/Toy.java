package com.strafeup.task3.part1.model;

import java.util.Objects;

public abstract class Toy {
    protected String name;
    protected Material material;
    protected double heigth;
    protected double width;
    protected double depth;
    protected double price;

    public Toy(String name, double heigth, double width, double depth, double price) {
        this.name = name;
        this.heigth = heigth;
        this.width = width;
        this.depth = depth;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", material=" + material +
                ", heigth=" + heigth +
                ", width=" + width +
                ", depth=" + depth +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Toy)) return false;
        Toy toy = (Toy) o;
        return Double.compare(toy.heigth, heigth) == 0 &&
                Double.compare(toy.width, width) == 0 &&
                Double.compare(toy.depth, depth) == 0 &&
                Double.compare(toy.price, price) == 0 &&
                Objects.equals(name, toy.name) &&
                material == toy.material;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, material, heigth, width, depth, price);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public double getHeigth() {
        return heigth;
    }

    public double getWidth() {
        return width;
    }

    public double getDepth() {
        return depth;
    }
    public double getSize(){
        return heigth * width * depth;
    }
}
