package a.tasks;

import java.util.Arrays;

public class ArrayAsRanges {
    public static void main(String[] args) {
        System.out.println(toRanges(new int[]{1, 4, 5, 2, 3, 9, 8, 11, 0}));
        System.out.println(toRanges(new int[]{1, 4, 3, 2}));
        System.out.println(toRanges(new int[]{1, 4}));
        System.out.println(toRanges(new int[]{1, 4, 9}));
        System.out.println(toRanges(new int[]{-10, 4, 9, -9, -8}));
    }

    private static String toRanges(int[] arr) {
        StringBuilder sb = new StringBuilder();
        if (arr != null && arr.length > 0) {
            Arrays.sort(arr);
            int j = 0;
            Integer start = null;
            for (int x : arr) {
                if (start == null) { // on first element
                    sb.append(x);
                    start = x;
                } else if (x - j > 1) { // on iteration
                    if (!start.equals(j)) sb.append("-").append(j);
                    sb.append(",").append(x);
                    start = x;
                }
                j = x;
            }
        }
        return sb.toString();
    }
}
