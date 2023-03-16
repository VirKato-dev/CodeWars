package codewars.integers.recreation.two;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.LongStream.of;

public class IntegersRecreationTwo {
    public static void main(String[] args) {

    }
}

class SqProd2Sum {
    public static List<long[]> prod2Sum(long a, long b, long c, long d) {
        long a1 = Math.abs(b * c - a * d);
        long b1 = b * d + a * c;
        long c1 = Math.abs(b * d - a * c);
        long d1 = b * c + a * d;
        a = Math.min(a1, b1);
        b = Math.max(a1, b1);
        c = Math.min(c1, d1);
        d = Math.max(c1, d1);
        List<long[]> res = new ArrayList<>();
        res.add(new long[]{a, b});
        if (a != c) res.add(new long[]{c, d});
        return res;
    }
}

interface SqProd2Sum2 {
    static List<long[]> prod2Sum(long a, long b, long c, long d) {
        var ef1 = of(a * c + b * d, Math.abs(a * d - b * c)).sorted().toArray();
        var ef2 = of(a * d + b * c, Math.abs(a * c - b * d)).sorted().toArray();
        return ef1[0] == ef2[0] ? List.of(ef1) : List.of(ef1, ef2);
    }
}