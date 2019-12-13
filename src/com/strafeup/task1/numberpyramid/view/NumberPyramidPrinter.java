package com.strafeup.task1.numberpyramid.view;

public class NumberPyramidPrinter {
    public static void printPyramid(int pyramidHeight) {
        if (pyramidHeight > 9 || pyramidHeight < 0) {
            System.out.println("Can't build, height out of range, building to 9");
            pyramidHeight = 9;
        }
        for (int i = 1; i <= pyramidHeight; i++) {
            printLayer(i, pyramidHeight);

            System.out.println();
        }
    }

    private static void printLayer(int layerNumber, int pyramidHeight) {
        int num = 1;
        for (int i = 0; i <= pyramidHeight - layerNumber - 1; i++) {
            System.out.print(' ');
        }
        while (num <= layerNumber) {
            System.out.print(num);
            num++;
        }
        num--;
        num--;
        while (num >= 1) {
            System.out.print(num);
            num--;
        }
    }
}
