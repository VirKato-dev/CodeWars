package com.codewars.take.a.ten.minutes.walk.v3;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        if (walk.length != 10) return false;
        int dx = 0, dy = 0;
        for (char c : walk) {
            switch (c) {
                case 'n' -> dy++;
                case 's' -> dy--;
                case 'e' -> dx++;
                case 'w' -> dx--;
            }
        }
        return dx == 0 && dy == 0;
    }
}