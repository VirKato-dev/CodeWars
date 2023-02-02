package com.codewars.snail.sort.v4;

import java.util.Arrays;

public class Snail {
    public static int[] snail(int[][] array) {
        int i = 0, j = 0, di = 0, dj = 1;
        double l = 0;
        int[] res = {};
        while (res.length < array.length * array[0].length) {
            res = Arrays.copyOf(res, res.length + 1);
            res[res.length - 1] = array[i][j];
            array[i][j] = -1;
            if (i + di < 0 || i + di >= array.length || j + dj < 0 || j + dj >= array[0].length || array[i + di][j + dj] == -1) {
                l += Math.PI / 2;
                di = (int) Math.sin(l);
                dj = (int) Math.cos(l);
            }
            i += di;
            j += dj;
        }
        return res;
    }
}