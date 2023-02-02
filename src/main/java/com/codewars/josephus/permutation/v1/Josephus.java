package com.codewars.josephus.permutation.v1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {
        josephusPermutation(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 3).forEach(x -> System.out.print(x + ","));
    }

    public static <T> Collection<T> josephusPermutation(final List<T> items, final int k) {
        List<T> res = new ArrayList<>();
        int pos = 0;
        while (items.size() > 0) {
            pos = (pos + k - 1) % items.size();
            res.add(items.remove(pos));
        }
        return res;
    }
}