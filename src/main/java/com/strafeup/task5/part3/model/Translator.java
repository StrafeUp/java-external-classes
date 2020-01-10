package com.strafeup.task5.part3.model;

import java.util.HashMap;

public class Translator {

    private HashMap<String, String> dictionary = new HashMap<>();

    public void addPair(String word, String translation) {
        dictionary.put(word, translation);
    }

    public String translateLine(String line) {
        String[] words = line.split("[ ,]");
        StringBuilder sb = new StringBuilder();

        for (String word : words) {
            sb.append(dictionary.getOrDefault(word.toLowerCase(), word));
            sb.append(" ");
        }
        return sb.toString();
    }

    public void loadBasicWords() {
        dictionary.put("i","Я");
        dictionary.put("love","люблю");
        dictionary.put("like", "нравится");
        dictionary.put("see","вижу");
        dictionary.put("think","думаю");
        dictionary.put("want","хочу");
        dictionary.put("apple","яблоко");
        dictionary.put("apples","яблоки");
        dictionary.put("fruit","фрукт");
        dictionary.put("fruits","фрукты");
    }
}
