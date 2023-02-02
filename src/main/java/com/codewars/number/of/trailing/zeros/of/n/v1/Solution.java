package com.codewars.number.of.trailing.zeros.of.n.v1;

public class Solution {
    public static int zeros(final int n) {
        return (n < 5) ? 0 : (n / 5) + zeros(n / 5);
    }
}