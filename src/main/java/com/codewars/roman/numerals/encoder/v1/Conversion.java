package com.codewars.roman.numerals.encoder.v1;

public class Conversion {
    static final String R1[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    static final String R10[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    static final String R100[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    static final String R1000[] = {"", "M", "MM", "MMM"};

    public String solution(int n) {
        return R1000[n / 1000] + R100[n % 1000 / 100] + R10[n % 100 / 10] + R1[n % 10];
    }
}