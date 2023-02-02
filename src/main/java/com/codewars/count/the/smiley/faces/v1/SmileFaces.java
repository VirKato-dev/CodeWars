package com.codewars.count.the.smiley.faces.v1;

import java.util.List;

public class SmileFaces {

    public static int countSmileys(List<String> arr) {
        return (int) arr.stream().filter(x -> x.matches("[:;][-~]?[)D]")).count();
    }
}