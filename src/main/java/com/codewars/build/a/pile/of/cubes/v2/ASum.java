package com.codewars.build.a.pile.of.cubes.v2;

public class ASum {
    public static long findNb(long m) {
        long ex = (long) Math.sqrt((long) Math.sqrt(m) * 2); // корень из 2-х корней из m
        return (ex * (ex + 1) / 2) * (ex * (ex + 1) / 2) == m ? ex : -1;
    }
}