package com.codewars.find.the.missing.letter.v2;

public class Kata {
    public static char findMissingLetter(char[] array) {
        char start = array[0];
        for (char c : array) if (start++ != c) return start;
        return ' ';
    }
}