package com.strafeup.task1.matrixrotation.util;

import java.util.Random;

public class MatrixFiller {
    private static Random randGen = new Random();

    public static void initMatrixWithRange(Number[][] matrix, int min, int max) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = randGen.nextInt(max - min) + min;
            }
        }
    }

    public static void initMatrixWithoutRange(Number[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = randGen.nextInt();
            }
        }
    }
}
