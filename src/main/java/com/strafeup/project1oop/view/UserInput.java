package com.strafeup.project1oop.view;

import java.util.Scanner;

/**
 * Utility View class for getting user's input
 */
public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static int getNumberInput() {
        return sc.nextInt();
    }

    public static double getDoubleInput() {
        return sc.nextDouble();
    }

    public static String getWord() {
        return sc.next();
    }
}
