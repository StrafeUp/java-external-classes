package com.strafeup.task1.matrixrotation;

import com.strafeup.task1.matrixrotation.util.MatrixFiller;
import com.strafeup.task1.matrixrotation.util.MatrixRotation;
import com.strafeup.task1.matrixrotation.view.ConsolePrinter;

public class Main {


    public static void main(String[] args) {

        int N = 3;
        Number[][] matrix = new Number[N][N];

        MatrixFiller.initMatrixWithRange(matrix, -10, 10);

        ConsolePrinter.showMatrix(matrix);
        Number[][] newMatrix = MatrixRotation.counterClockwiseRotation(matrix);
        ConsolePrinter.showMatrix(newMatrix);
    }

}
