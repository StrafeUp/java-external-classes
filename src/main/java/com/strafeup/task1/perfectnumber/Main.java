package com.strafeup.task1.perfectnumber;


import com.strafeup.task1.perfectnumber.util.PerfectNumberGenerator;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList perfectNumberList = (ArrayList) PerfectNumberGenerator.generate(0, 100000);
        System.out.println(perfectNumberList.toString());
    }

}
