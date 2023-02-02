package com.codewars.sort.the.odd.v4;

import java.util.Arrays;
import java.util.Iterator;

public class Kata {
    public static int[] sortArray(int[] array) {
        Iterator<Integer> iterator = Arrays.stream(array).filter(e -> e % 2 != 0).sorted().iterator();
        return Arrays.stream(array).map(e -> e % 2 == 0 ? e : iterator.next()).toArray();
    }
}