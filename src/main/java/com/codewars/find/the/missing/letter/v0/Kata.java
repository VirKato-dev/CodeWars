package com.codewars.find.the.missing.letter.v0;

public class Kata {
    public static char findMissingLetter(char[] array) {
        char last = array[0];
        for (char c : array) {
            if (c - last > 1) return (char) (last + 1);
            last = c;
        }
        return ' ';
    }
}