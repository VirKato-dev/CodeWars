package com.codewars.range.extraction.v0;

import java.util.Arrays;
import java.util.StringJoiner;

class Solution {

    public static void main(String[] args) {
        System.out.println(rangeExtraction(new int[]{-6, -3, -2, -1, 0, 1, 3, 4, 5, 7, 8, 9, 10, 11, 14, 15, 17, 18, 19, 20}));
        System.out.println(rangeExtraction(new int[]{-3, -2, -1, 2, 10, 15, 16, 18, 19, 20, 22}));
    }

    public static String rangeExtraction(int[] arr) {
        System.out.println(Arrays.toString(arr));
        int exp = 0, step = 0, begin = 0, end;
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = 0;

        StringJoiner res = new StringJoiner(",");
        for (int i = 0; i < arr.length; i++) {
            if (step == 0) {
                begin = arr[i];
                exp = begin;
            } else {
                end = arr[i];
                if (end != exp || i == arr.length - 1) {
                    if (step > 2) {
                        res.add(begin + "-" + (exp - 1));
                    } else {
                        if (step == 1) {
                            res.add("" + begin);
                        } else {
                            res.add(begin + "," + (exp - 1));
                        }
                    }
                    begin = end;
                    exp = begin;
                    step = 0;
                }
            }
            step++;
            exp++;
        }
        return res.toString();
    }
}