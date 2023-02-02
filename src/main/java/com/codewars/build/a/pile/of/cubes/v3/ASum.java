package com.codewars.build.a.pile.of.cubes.v3;

public class ASum {
    public static long findNb(long m) {
        long n = 0;
        while ((m -= ++n * n * n) > 0) ;
        return m == 0 ? n : -1;
    }
}