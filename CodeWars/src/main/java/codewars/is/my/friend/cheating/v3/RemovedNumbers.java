package codewars.is.my.friend.cheating.v3;

import java.util.ArrayList;
import java.util.List;

public class RemovedNumbers {
    public static List<long[]> removNb(long n) {
        long sum = (n + 1) * n / 2;
        sum = sum + 1;
        List<long[]> list = new ArrayList<>();
        for (long i = sum / n; i < Math.sqrt(sum); i++) {
            if (sum % i == 0) {
                long j = sum / i;
                list.add(new long[]{i - 1, j - 1});
                list.add(new long[]{j - 1, i - 1});
            }
        }
        list.sort((o1, o2) -> (int) (o1[0] - o2[0]));
        return list;
    }
}