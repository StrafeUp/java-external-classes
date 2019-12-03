package com.strafeup.task1.matrixrotation.util;

public class MatrixRotation {
    public static Number[][] counterClockwiseRotation(Number[][] matrix) {
        Number[][] newMatrix = new Number[matrix.length][matrix[0].length];
        int subvar = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = matrix[0].length - 1; j >= 0; j--) {
                newMatrix[subvar][i] = matrix[i][j];
                subvar++;
            }
            subvar = 0;
        }
        return newMatrix;
    }

}
