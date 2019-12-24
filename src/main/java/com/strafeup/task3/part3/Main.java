package com.strafeup.task3.part3;

public class Main {


    public static void main(String[] args) {
        WarningLevel warningLevel = WarningLevel.MEDIUM;
        WarningLevel[] warningLevels = WarningLevel.values();
        for (WarningLevel lvl : warningLevels) {
            System.out.println(lvl);
        }
        System.out.println(warningLevel);
    }
}
