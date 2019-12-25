package com.strafeup.task3.part2.util;

public class Tokenizer {
    public static String[] getTokensFromString(String line, String splitter) {
        return line.split(splitter);
    }
}
