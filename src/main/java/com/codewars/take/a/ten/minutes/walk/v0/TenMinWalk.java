package com.codewars.take.a.ten.minutes.walk.v0;

public class TenMinWalk {
    public static boolean isValid(char[] walk) {
        String w = new String(walk);
        return w.length() == 10
                && w.replace("n", "").length() == w.replace("s", "").length()
                && w.replace("w", "").length() == w.replace("e", "").length();
    }
}