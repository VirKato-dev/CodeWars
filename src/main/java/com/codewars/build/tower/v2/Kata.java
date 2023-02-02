package com.codewars.build.tower.v2;

public class Kata {
    public static String[] towerBuilder(int nFloors) {
        return java.util.stream.IntStream.rangeClosed(1, nFloors)
                .mapToObj(x -> " ".repeat(nFloors - x) + "*".repeat(x * 2 - 1) + " ".repeat(nFloors - x))
                .toArray(String[]::new);
    }
}