package com.strafeup.task2.part1.model;

import java.util.Random;

public class ShapePool {
    private AbstractShape[] innerArr;

    public AbstractShape[] getShapeArray() {
        return innerArr;
    }

    public ShapePool(int size) {
        this.innerArr = new AbstractShape[size];

        for (int i = 0; i < size; i++) {
            Random random = new Random();
            int ind = random.nextInt(3);
            switch (ind) {
                case 0:
                    innerArr[i] = new Circle("Yellow", random.nextDouble());
                    break;
                case 1:
                    innerArr[i] = new Rectangle("Red", random.nextDouble(), random.nextDouble());
                    break;
                case 2:
                    innerArr[i] = new Triangle("Green", random.nextDouble()+1, random.nextDouble()+1, random.nextDouble()+1);
                    break;
            }
        }
    }

}
