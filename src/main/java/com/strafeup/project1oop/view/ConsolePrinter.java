package com.strafeup.project1oop.view;

import com.strafeup.project1oop.model.entity.Salad;

public class ConsolePrinter {
    public static void print(String text) {
        System.out.println(text + '\n');
    }

    public static void printSaladInfo(Salad salad) {
        System.out.println(salad);
    }
}
