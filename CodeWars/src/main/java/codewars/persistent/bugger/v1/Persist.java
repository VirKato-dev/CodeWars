package codewars.persistent.bugger.v1;

class Persist {
    public static int persistence(long n) {
        long m = 1, r = n;
        if (r / 10 == 0) return 0;
        for (r = n; r != 0; r /= 10) m *= r % 10;
        return persistence(m) + 1;
    }
}