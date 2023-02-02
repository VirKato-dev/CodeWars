package com.codewars.build.tower.v0;

import java.util.Arrays;

public class Kata {

    public static void main(String[] args) {
        Arrays.stream(towerBuilder(6)).forEach(System.out::println);
    }

    public static String[] towerBuilder(int nFloors) {
        String[] res = new String[nFloors];
        for (int i = 0; i < nFloors; i++) {
            String margin = " ".repeat(nFloors-i-1);
            res[i] = margin + "*".repeat(i*2+1) + margin;
        }
        return res;
    }
}