package my.virkato;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ArtCritic2 {
    public static void main(String[] args) {
        long res = 0;
        Map<Integer, Long> map = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int len = 0;
        int start = 0;
        long tmp;
        for (int j = 0; j < m || !map.isEmpty(); j++) {
            tmp = 0;
            if (j < m) tmp = in.nextInt();

            if (tmp > 0) {
                if (tmp > n) tmp = n;
                map.put(len, tmp);
            }

            if (map.containsKey(start) && (map.get(start) == len - start || j >= m)) {
                for (int k = start; k <= len; k++) {
                    if (k==start) {
                        map.put(start, map.get(start) * map.get(k));
                    } else {
                        long score = 0;
                        if (map.containsKey(k)) score = map.get(k);
                        map.put(start, map.get(start) + score);
                    }
                }
                res += map.remove(start);
                start++;
            }

            if (tmp > 0) len++;
        }

        System.out.println("" + res);
    }
}
