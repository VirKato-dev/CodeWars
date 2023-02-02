package com.codewars.snail.sort.v5;

public class Snail {
    public static int[] snail(int[][] array) {
        int size = array.length;
        if (size == 1 && array[0].length == 0) return new int[0];
        int[] result = new int[size * size];
        int x = 0;
        int y = 0;
        int length;
        int pointer = 0;
        for (int n = size; n > 0; n -= 2, x++, y++) {
            if (n - 1 == 0) {
                result[pointer] = array[y][x];
            } else {
                length = n - 1;
                for (int i = 0; i < length; i++) {
                    result[pointer              + i] = array[y             ][x          + i];
                    result[pointer     + length + i] = array[y          + i][x + length    ];
                    result[pointer + 2 * length + i] = array[y + length    ][x + length - i];
                    result[pointer + 3 * length + i] = array[y + length - i][x             ];
                }
                pointer += 4 * length;
            }
        }
        return result;
    }
}