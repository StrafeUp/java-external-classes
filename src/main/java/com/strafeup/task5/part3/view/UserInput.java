package com.strafeup.task5.part3.view;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static String getLine() {
        return sc.nextLine();
    }

    public static int getNumber() {
        return Integer.parseInt(sc.nextLine());
    }
}
