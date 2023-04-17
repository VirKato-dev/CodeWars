package ru.rtech.interview.task1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task1 {

    private static final String TEXT = "I am Java Developer";

    /*
     *   *************
     *   * I         *
     *   * am        *
     *   * Java      *
     *   * Developer *
     *   *************
     */

    /**
     * Реализовать функцию вывода на консоль текста в параметре TEXT в формате указанном выше
     */
    @Test
    public void printFormattedText() {
//        throw new UnsupportedOperationException("Implemented it!");
        int maxLen = 0;
        List<String> words = new ArrayList<>();
        Scanner in = new Scanner(TEXT);
        while (in.hasNext()) {
            String word = in.next();
            words.add(word);
            if (maxLen < word.length()) maxLen = word.length();
        }
        System.out.println("*".repeat(maxLen + 4));
        for (String s : words) {
            System.out.println("* " + s + " ".repeat(maxLen - s.length()) + " *");
        }
        System.out.println("*".repeat(maxLen + 4));
    }
}
