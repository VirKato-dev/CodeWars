package com.codewars.create.phone.number.v1;

public class Kata {
    public static String createPhoneNumber(int[] numbers) {
        return String.format("(%d%d%d) %d%d%d-%d%d%d%d", java.util.stream.IntStream.of(numbers).boxed().toArray());
    }
}