package codewars.josephus.permutation.v0;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Josephus {

    public static void main(String[] args) {
        josephusPermutation(new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)), 3).forEach(x -> System.out.print(x + ","));
    }

    public static <T> List<T> josephusPermutation(final List<T> items, final int k) {
        List<T> res = new ArrayList<>();
        int pos = -1;
        while (res.size() < items.size()) {
            long count = k;
            while (count-- > 0) {
                do pos = ++pos % items.size(); while (items.get(pos) == null);
            }
            res.add(items.get(pos));
            items.set(pos, null);
        }
        return res;
    }
}