package com.strafeup.task3.part1.model;

import com.strafeup.task3.part1.controller.comparators.CompareToysByName;
import com.strafeup.task3.part1.controller.comparators.CompareToysByPrice;
import com.strafeup.task3.part1.controller.comparators.CompareToysBySize;

import java.util.ArrayList;
import java.util.List;

public class PlayingRoom<T extends Toy> {


    public List<T> sortToysBy(List<T> toysList, String field) {
        switch (field) {
            case "Name":
                toysList.sort(new CompareToysByName());
                break;
            case "Price":
                toysList.sort(new CompareToysByPrice());
                break;
            case "Size":
                toysList.sort(new CompareToysBySize());
                break;

        }
        return toysList;
    }

    public double countSumPrice(List<T> toys) {
        double sum = 0;
        for (T t : toys) {
            sum += t.getPrice();
        }
        return sum;
    }


    public List<T> findByField(List<T> toysList, String field, double min, double max) {
        List<T> newList = new ArrayList<>();
        switch (field) {

            case "Name":
                for (int i = 0; i < toysList.size(); i++) {
                    if (!(toysList.get(i).getName().equalsIgnoreCase(field))) {
                        toysList.remove(i);
                        i--;
                    }
                }
                break;

            case "Price":
                for (int i = 0; i < toysList.size(); i++) {
                    if (!(toysList.get(i).getPrice() < max & toysList.get(i).getPrice() > min)) {
                        toysList.remove(i);
                        i--;
                    }
                }
                break;

            case "Size":
                for (int i = 0; i < toysList.size(); i++) {
                    if (!(toysList.get(i).getSize() < max && toysList.get(i).getSize() > min)) {
                        toysList.remove(i);
                        i--;
                    }
                }
                break;
        }

        return toysList;
    }
}

