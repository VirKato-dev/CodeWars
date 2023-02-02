package com.codewars.playing.with.digits.v1;

import java.util.stream.IntStream;

public class DigPow {
    public static long digPow(int n, int p) {
        int[] digits = String.valueOf(n).chars().map(Character::getNumericValue).toArray();
        int sum = IntStream.range(0, digits.length).map(i -> (int) Math.pow(digits[i], i + p)).sum();
        return sum % n == 0 ? sum / n : -1;
    }
}