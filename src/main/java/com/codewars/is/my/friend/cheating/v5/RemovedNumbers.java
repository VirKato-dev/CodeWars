package com.codewars.is.my.friend.cheating.v5;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        List<long[]> res = new ArrayList<>();
        long sum = n * (n + 1) / 2;
        for (long i = n / 2; i <= n; i++) {
            long x = (sum - i) / (i + 1);
            if ((sum - i) % (i + 1) == 0 && x <= n) {
                res.add(new long[]{i, x});
            }
        }
        return res;
    }
}