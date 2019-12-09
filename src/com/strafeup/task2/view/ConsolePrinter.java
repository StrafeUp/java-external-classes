package com.strafeup.task2.view;

public class ConsolePrinter extends AbstractPrinter {
    @Override
    public void print(Object o) {
        System.out.println(o);
    }
}
