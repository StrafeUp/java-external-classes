package com.strafeup.task1.baseconverter.util;


import static java.lang.Math.floor;
import static java.lang.Math.pow;

public class BaseConverter {
    public static String convert(int number, int base) {

        String result;
        switch (base) {
            case 2:
                result = decToBase(BasesConst.BINARY, number);
                break;
            case 8:
                result = decToBase(BasesConst.OCTAL, number);
                break;
            case 16:
                result = toHex(number);
                break;
            default:
                return String.valueOf(number);
        }

        return result;
    }

    private static String decToBase(int base, int n) {

        int num = 0;
        int i = 0;
        int quotient = n;
        int remainder;

        while (quotient != 0) {
            remainder = quotient % base;
            quotient = quotient / base;
            num = (int) floor(pow(10, i) * remainder + num);
            i++;
        }


        return String.valueOf(num);
    }

    private static String toHex(int number) {
        int remainder;
        String hex = "";
        char[] hexChars = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
        while (number > 0) {
            remainder = number % 16;
            hex = hexChars[remainder] + hex;
            number = number / 16;
        }
        return hex;
    }
}
