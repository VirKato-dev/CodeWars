package codewars.is.my.friend.cheating.v4;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        List<long[]> res = new ArrayList<>();
        for (long a = n / 2; a < n; a++) {
            double b = (n * n + n - 2 * a) / (2.0 * a + 2);
            if (b == (long) b)
                res.add(new long[]{a, (long) b});
        }
        return res;
    }
}