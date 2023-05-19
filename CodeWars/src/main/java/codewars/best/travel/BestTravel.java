package codewars.best.travel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//todo не решено
public class BestTravel {
    public static void main(String[] args) {
        System.out.println("****** Basic Tests small numbers******");
        List<Integer> ts = new ArrayList<>(Arrays.asList(50, 55, 56, 57, 58));
        Integer n = SumOfK.chooseBestSum(163, 3, ts);
        if (n == null || 163 != n) System.out.println("Wrong 1");

//        ts = new ArrayList<>(List.of(50));
//        Integer m = SumOfK.chooseBestSum(163, 3, ts);
//        if (m != null) System.out.println("Wrong 2");

//        ts = new ArrayList<>(Arrays.asList(91, 74, 73, 85, 73, 81, 87));
//        n = SumOfK.chooseBestSum(230, 3, ts);
//        if (n == null || n != 228) System.out.println("Wrong 3");
    }
}

class SumOfK {
    public static Integer chooseBestSum(int t, int k, List<Integer> ls) {
        Collections.reverse(ls);
        List<Integer> res = new ArrayList<>();
        for (int j = 0; j < ls.size() - k; j++) {
            res.add(sum(t-ls.get(j), k-1, ls, j+1));
        }
        Collections.reverse(res);
        return res.size() > 0 ? res.get(0) : null;
    }

    private static int sum(int t, int k, List<Integer> ls, int start) {
        if (k < 0 || start == ls.size()) return 0;
        int max = 0;
        for (int j = start; j < ls.size() - k; j++) {
            int r = sum(t - ls.get(j), k-1, ls, j + 1);
            if (t - r >= 0) {
                if (max < r) max = r;
            }
            System.out.println(t+"-"+k+"-"+j+"-"+max);
        }
        return max;
    }
}
