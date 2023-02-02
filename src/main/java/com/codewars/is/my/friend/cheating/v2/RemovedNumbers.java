package com.codewars.is.my.friend.cheating.v2;

import java.util.LinkedList;
import java.util.List;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        List<long[]> list = new LinkedList<>();
        long sum = (n * n + n) / 2;
        long halfN = n / 2;
        long sqrtN = (long) Math.sqrt(n);
        for (long i = halfN; i <= n - sqrtN; i++) {
            long sumMinusI = sum - i;
            if (sumMinusI % (i + 1) == 0) {
                long j = sumMinusI / (i + 1);
                list.add(new long[]{i, j});
            }
        }
        return list;
    }
}