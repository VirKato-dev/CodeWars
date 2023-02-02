package com.codewars.create.phone.number.v0;

public class Kata {
    public static String createPhoneNumber(int[] d) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", d[0], d[1], d[2], d[3], d[4], d[5], d[6], d[7], d[8], d[9]);
    }
}