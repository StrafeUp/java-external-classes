package com.strafeup.task1.perfectnumber.util;

import java.util.ArrayList;
import java.util.List;

public class PerfectNumberGenerator {

    public static List<Integer> generate(int lowerBound, int upperBound) {
        List<Integer> ints = new ArrayList<>();
        if (lowerBound <= 0) {
            System.err.println("Cannot start from 0 or negative. Starting from 1:");
            lowerBound = 1;
        }

        for (int i = lowerBound; i < upperBound; i++) {
            if (checkNumber(i)) {
                ints.add(i);
            }
        }
        return ints;
    }

    private static boolean checkNumber(int n) {
        int sum = 0;
        for (int i = 1; i < n; i++) {
            if (n % i == 0) {
                sum = sum + i;
            }
        }
        return sum == n;
    }
}
