package com.codewars.who.likes.it.v2;

public class Solution {
    public static String whoLikesIt(String... names) {
        String[] msgFormat = {"no one likes this",
                "- likes this",
                "- and - like this",
                "-, - and - like this",
                "-, - and -- others like this"};
        String msg = msgFormat[Math.min(names.length, 4)];
        for (String name : names) {
            msg = msg.replaceFirst("-", name);
            msg = msg.replaceFirst("--", "" + (names.length - 2));
        }
        return msg;
    }
}