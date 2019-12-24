package com.strafeup.task1.matrixrotation.view;

public class ConsolePrinter {
    public static void showMatrix(Number[][] matrix) {
        for (Number[] row : matrix) {
            for (Number el : row) {
                System.out.print(el + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
