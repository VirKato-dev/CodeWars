package codewars.who.likes.it.v0;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        System.out.println(whoLikesIt());
        System.out.println(whoLikesIt("Peter"));
        System.out.println(whoLikesIt("Max", "John", "Mark"));
        System.out.println(whoLikesIt("Alex", "Jacob", "Mark", "Max"));
    }

    public static String whoLikesIt(String... names) {
        String template = "no one likes this";
        if (names.length == 1) template = "%s likes this";
        if (names.length == 2) template = "%s and %s like this";
        if (names.length == 3) template = "%s, %s and %s like this";
        String res = String.format(template, names);
        if (names.length > 3) {
            template = "%s, %s and %d others like this";
            res = String.format(template, names[0], names[1], names.length-2);
        }
        return res;
    }
}