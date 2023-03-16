package codewars.perimeter.of.squares.in.a.rectangle.v2;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.ZERO;

public class SumFct {
    public static BigInteger perimeter(BigInteger n) {
        return Stream.iterate(new BigInteger[]{ZERO, ONE}, i -> new BigInteger[]{i[1], i[0].add(i[1])})
                .limit(n.intValueExact() + 1)
                .map(i -> i[1])
                .reduce(ZERO, BigInteger::add)
                .shiftLeft(2);
    }
}