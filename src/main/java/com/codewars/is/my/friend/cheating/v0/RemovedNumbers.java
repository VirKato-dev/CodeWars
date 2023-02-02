package com.codewars.is.my.friend.cheating.v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemovedNumbers {

    public static void main(String[] args) {
        removNb(26).forEach(a -> System.out.println(Arrays.toString(a)));
    }


    public static List<long[]> removNb0(long n) { // O(n^2) - неэффективный алгоритм
        List<long[]> list = new ArrayList<>();
        long sum = (n * (n + 1)) / 2; // сумма всех чисел от 1 до n
        for (long i = 1; i < n; i++) {
            for (long j = i + 1; j <= n; j++) {
                long production = i * j;
                if (production == sum - i - j) {
                    list.add(new long[]{i, j});
                    list.add(new long[]{j, i});
                }
            }
        }
        return list;
    }


    public static List<long[]> removNb(long n) { // O(n/2)
        List<long[]> list = new ArrayList<>();
        long sum = (n * (n + 1)) / 2;
        for (long i = n / 2; i < n; i++) { // (int i = 1) -- O(n)
            // i * x = sum - i - x
            // x = (sum - i - x) / i
            // x = (sum - i) / i - x / i
            // x + x / i = (sum - i) / i
            // x * i + x = sum - i
            // x * (i + 1) = sum - i
            // x = (sum - i) / (i + 1)
            long x = (sum - i) / (i + 1);
            if (x <= n && x * i == sum - i - x) { // x <= n  &&  (sum - i) % (i + 1) == 0
                list.add(new long[]{i, x});
            }
        }
        return list;
    }
}