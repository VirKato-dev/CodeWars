package codewars.persistent.bugger.v3;

import java.util.Arrays;

class Persist {
    public static int persistence(long n) {
        return (n < 10 ? 0 : 1 + persistence(
                Arrays.stream(Long.toString(n).split(""))
                        .mapToLong(Long::parseLong)
                        .reduce((left, right) -> left * right)
                        .getAsLong()
        ));
    }
}