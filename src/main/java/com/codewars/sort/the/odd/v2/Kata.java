package com.codewars.sort.the.odd.v2;

import java.util.PrimitiveIterator.OfInt;
import java.util.stream.IntStream;

public class Kata {
    public static int[] sortArray(int[] array) {
        OfInt sortedOdds = IntStream
                .of(array)
                .filter(i -> i % 2 == 1)
                .sorted()
                .iterator();
        return IntStream
                .of(array)
                .map(i -> i % 2 == 0 ? i : sortedOdds.nextInt())
                .toArray();
    }
}