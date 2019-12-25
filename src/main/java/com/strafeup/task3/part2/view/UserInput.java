package com.strafeup.task3.part2.view;

import java.util.Scanner;

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
    public static String getLine() {
        return sc.nextLine();
    }
}
