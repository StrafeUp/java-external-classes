package com.strafeup.task5.part4.Controller;

import com.strafeup.task5.part4.model.RedBlackTree;
import com.strafeup.task5.part4.view.ConsolePrinter;

import java.util.Random;

public class RBTreeController {
    private int SIZE = 15;
    private int lowerBound = 0;
    private int upperBound = 150;

    private RedBlackTree redBlackTree;
    private Random random = new Random();

    public RBTreeController() {
        redBlackTree = new RedBlackTree();
    }

    public void start() {
        StringBuilder sb = new StringBuilder();
        sb.append("Random numbers: ");

        for (int i = 0; i < SIZE; i++) {
            int tempNum = random.nextInt(upperBound-lowerBound+1);
            redBlackTree.insert(tempNum);
            sb.append(tempNum).append(", ");
        }
        ConsolePrinter.println(sb.toString());
        redBlackTree.printTree();

    }
}
