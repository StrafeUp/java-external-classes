package com.strafeup.task3.part2.view;

import com.strafeup.task3.part2.model.Shop;

public class ConsolePrinter {
    public static void print(String text) {
        System.out.println(text);
    }

    public static void printDepartments(Shop.Department[] departments) {
        for (Shop.Department department : departments) {
            System.out.println(department);
        }
    }
}
