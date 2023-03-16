package codewars.persistent.bugger.v2;

class Persist {
    public static int persistence(long n) {
        int times = 0;
        while (n > 9) {
            n = Long.toString(n).chars().reduce(1, (r, i) -> r * (i - '0'));
            times++;
        }
        return times;
    }
}