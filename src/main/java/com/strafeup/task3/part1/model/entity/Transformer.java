package com.strafeup.task3.part1.model.entity;

import com.strafeup.task3.part1.model.Material;
import com.strafeup.task3.part1.model.Toy;
import com.strafeup.task3.part1.model.Transformable;

public class Transformer extends Toy implements Transformable {

    public Transformer(String name, double height, double width, double depth, double price) {
        super(name, height, width, depth, price);
        material = Material.PLASTIC;
    }

    @Override
    public void transform() {
        heigth = heigth / 2;
        width = width / 2;
        depth = depth / 2;
    }
}
