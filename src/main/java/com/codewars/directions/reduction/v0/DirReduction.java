package com.codewars.directions.reduction.v0;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DirReduction {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(dirReduc(new String[]{"NORTH", "SOUTH", "SOUTH", "EAST", "WEST", "NORTH", "WEST"})));
    }

    public static String[] dirReduc(String[] arr) {
        String way = Arrays.stream(arr).map(s -> switch (s) {
            case "NORTH" -> "n";
            case "SOUTH" -> "s";
            case "EAST" -> "e";
            case "WEST" -> "w";
            default -> "";
        }).reduce(String::concat).get();

        Pattern pat = Pattern.compile("(ns)|(sn)|(ew)|(we)");
        Matcher mat;
        while ((mat = pat.matcher(way)).find()) {
            way = mat.replaceAll("");
        }

        return way.chars()
                .mapToObj(c -> switch (c) {
                    case 'n' -> "NORTH";
                    case 's' -> "SOUTH";
                    case 'e' -> "EAST";
                    case 'w' -> "WEST";
                    default -> "";
                }).toArray(String[]::new);
    }
}
