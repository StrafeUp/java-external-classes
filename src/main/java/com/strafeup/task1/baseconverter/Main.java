package com.strafeup.task1.baseconverter;

import com.strafeup.task1.baseconverter.util.BaseConverter;
import com.strafeup.task1.baseconverter.util.BasesConst;
import com.strafeup.task1.baseconverter.view.ConsolePrinter;

public class Main {
    public static void main(String[] args) {
        String convertedNum = BaseConverter.convert(123, BasesConst.HEXADECIMAL);
        ConsolePrinter.print(convertedNum);
    }
}
