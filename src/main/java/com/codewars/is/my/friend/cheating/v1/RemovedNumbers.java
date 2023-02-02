package com.codewars.is.my.friend.cheating.v1;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        long sum = n * (1 + n) / 2;
        return LongStream.rangeClosed(1, n)
                .filter(i -> (sum + 1) % (i + 1) == 0)
                .mapToObj(i -> new long[]{i, (sum + 1) / (i + 1) - 1})
                .filter(i -> i[0] != i[1] && i[1] <= n)
                .collect(Collectors.toList());
    }
}