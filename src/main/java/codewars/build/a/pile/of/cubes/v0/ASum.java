package codewars.build.a.pile.of.cubes.v0;

public class ASum {
    public static long findNb(long m) {
        long i = 0;
        while (m > 0) {
            i++;
            m -= i * i * i;
        }
        return m == 0 ? i : -1;
    }
}