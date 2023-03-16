package codewars.perimeter.of.squares.in.a.rectangle.v3;

import java.math.BigInteger;
import java.util.HashMap;

/**
 *  Compute Fibonacci number using Dijkstra's recurrence:
 *    F(2N-1)  = F(N-1)^2 + F(N)^2
 *    F(2N)    = (2 F(N-1) + F(N)) F(N)
 *  Reference: http://introcs.cs.princeton.edu/java/92symbolic/Fibonacci.java
 **/
public class SumFct {
    private static final HashMap<BigInteger, BigInteger> cache = new HashMap<>();
    private static final BigInteger ONE = BigInteger.ONE;
    private static final BigInteger ZERO = BigInteger.ZERO;

    public static void main(String[] args) {
        System.out.println(perimeter(BigInteger.valueOf(5)));
        System.out.println(perimeter(BigInteger.valueOf(7)));
        System.out.println(perimeter(BigInteger.valueOf(30)));
    }

    public static BigInteger fibonacci(BigInteger n) {
        if (n.equals(ZERO)) return ZERO;
        if (n.equals(ONE)) return ONE;
        if (cache.containsKey(n)) return cache.get(n);
        BigInteger result;
        BigInteger n2 = n.shiftRight(1);
        if (n.testBit(0)) { // odd
            BigInteger n3 = n2.add(ONE);
            result = fibonacci(n2).multiply(fibonacci(n2)).add(fibonacci(n3).multiply(fibonacci(n3)));
        } else { // even
            BigInteger n3 = n2.subtract(ONE);
            result = fibonacci(n2).multiply(fibonacci(n2).add(fibonacci(n3).add(fibonacci(n3))));
        }
        cache.put(n, result);
        return result;
    }

    public static BigInteger perimeter(BigInteger n) {
        return fibonacci(n.add(BigInteger.valueOf(3))).subtract(ONE).shiftLeft(2);
    }
}