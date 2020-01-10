package com.strafeup.task5.part2.view;

import java.util.Scanner;

public class UserInput {
    private static Scanner sc = new Scanner(System.in);

    public static int getNumber(){
        return sc.nextInt();
    }

    public static int getNumber(String text){
        ConsolePrinter.print(text);
        return getNumber();
    }
}
