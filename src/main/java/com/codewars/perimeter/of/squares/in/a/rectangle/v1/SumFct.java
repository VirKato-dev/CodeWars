package com.codewars.perimeter.of.squares.in.a.rectangle.v1;

import java.math.BigInteger;
import java.util.stream.Stream;

public class SumFct {
    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(5)));
        System.out.println(perimeter(BigInteger.valueOf(7)));
        System.out.println(perimeter(BigInteger.valueOf(30)));
    }

    public static BigInteger perimeter(BigInteger n) {
        BigInteger[] last = {BigInteger.ZERO};
        return Stream.iterate(BigInteger.ONE, x -> {
                    BigInteger x1 = x;
                    x = last[0].add(x);
                    last[0] = x1;
                    return x;
                })
                .limit(n.intValue() + 1).reduce(BigInteger::add).get().multiply(BigInteger.valueOf(4));
    }
}