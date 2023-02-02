package com.codewars.parseInt.reloaded.v4;

public class Parser {
    public static int parseInt(String numStr) {
        var ret = 0;
        for (var word : numStr.split("[ -]")) {
            ret = switch (word) {
                case "one" -> ret + 1;
                case "two" -> ret + 2;
                case "three" -> ret + 3;
                case "four" -> ret + 4;
                case "five" -> ret + 5;
                case "six" -> ret + 6;
                case "seven" -> ret + 7;
                case "eight" -> ret + 8;
                case "nine" -> ret + 9;
                case "ten" -> ret + 10;
                case "eleven" -> ret + 11;
                case "twelve" -> ret + 12;
                case "thirteen" -> ret + 13;
                case "fourteen" -> ret + 14;
                case "fifteen" -> ret + 15;
                case "sixteen" -> ret + 16;
                case "seventeen" -> ret + 17;
                case "eighteen" -> ret + 18;
                case "nineteen" -> ret + 19;
                case "twenty" -> ret + 20;
                case "thirty" -> ret + 30;
                case "forty" -> ret + 40;
                case "fifty" -> ret + 50;
                case "sixty" -> ret + 60;
                case "seventy" -> ret + 70;
                case "eighty" -> ret + 80;
                case "ninety" -> ret + 90;
                case "hundred" -> ret + (ret % 1_000) * 99; //h*100-h;
                case "thousand" -> ret * 1_000;
                case "million" -> ret * 1_000_000;
                default -> ret;
            };
        }
        return ret;
    }
}