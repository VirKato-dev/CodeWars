package com.codewars.snail.sort.v2;

public class Snail {
    public static int[] snail(int[][] a) {
        int n = a[0].length, ret[] = new int[n * n], o = 0, j = 0;
        while (n > 0) {
            for (int x = o, y = o; x < o + n; x++) ret[j++] = a[y][x];
            for (int x = o + n - 1, y = o + 1; y < o + n; y++) ret[j++] = a[y][x];
            for (int x = o + n - 2, y = o + n - 1; x >= o; x--) ret[j++] = a[y][x];
            for (int x = o, y = o + n - 2; y > o; y--) ret[j++] = a[y][x];
            o++;
            n -= 2;
        }
        return ret;
    }
}