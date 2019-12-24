package com.strafeup.task3.part1.model.entity;

import com.strafeup.task3.part1.model.Material;
import com.strafeup.task3.part1.model.Toy;

public class PlushToy extends Toy {
    public PlushToy(String name, double heigth, double width, double depth, double price) {
        super(name, heigth, width, depth, price);
        material = Material.FABRIC;
    }
}
