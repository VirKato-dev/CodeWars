package com.codewars.ones.and.zeros.v0;

import java.util.Arrays;
import java.util.List;

public class BinaryArrayToNumber {

    public static void main(String[] args) {
        System.out.println(convertBinaryArrayToInt(Arrays.asList(1, 0, 1, 0)));
    }

    public static int convertBinaryArrayToInt(List<Integer> binary) {
        return binary.stream().reduce((a, c) -> (a << 1) + c).get();
    }
}