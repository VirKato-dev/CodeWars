package codewars.build.a.pile.of.cubes.v1;

public class ASum {
    public static long findNb(long m) {
        long mm = 0, n = 0;
        while (mm < m) mm += ++n * n * n;
        return mm == m ? n : -1;
    }
}