package tasks;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;


public class FindSumInArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(
                findSum(new int[]{1, 2, 3, 4, 5, 6}, 5)
        ));
    }

    private static int[] findSum(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int x : arr) {
            if (set.contains(sum - x)) {
                return new int[]{sum - x, x};
            }
            set.add(x);
        }
        return new int[]{};
    }
}
