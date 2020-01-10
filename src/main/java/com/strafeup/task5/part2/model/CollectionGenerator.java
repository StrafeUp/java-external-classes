package com.strafeup.task5.part2.model;

import java.util.*;

public class CollectionGenerator {
    private List<Object> objectList;
    private Set<Object> objectSet;
    private Random random = new Random();

    public CollectionGenerator() {
        objectList = new ArrayList<>();
        objectSet = new HashSet<>();
    }

    public List<Object> getObjectList() {
        return objectList;
    }

    public Set<Object> getObjectSet() {
        return objectSet;
    }

    public void generateList(int quantity, int lowerBound, int upperBound) {
        for (int i = 0; i < quantity; i++) {
            objectList.add(random.nextInt(upperBound - lowerBound + 1));
        }
    }

    public void generateSet(int quantity, int lowerBound, int upperBound) {
        for (int i = 0; i < quantity; i++) {
            objectSet.add(random.nextInt(upperBound - lowerBound + 1));
        }
    }
}
