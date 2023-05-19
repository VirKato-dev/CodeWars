package codewars.find.the.unique.number;

import java.util.Arrays;

public class FindTheUniqueNumber {
    public static void main(String[] args) {
        System.out.println(findUniq(new double[]{0, 1, 0}));
        System.out.println(findUniq(new double[]{1, 1, 1, 2, 1, 1}));
        System.out.println(findUniq(new double[]{}));
    }


    public static double findUniqBest(double arr[]) { // O(n)
        final double x = arr[arr[0] == arr[1] ? 0 : 2];
        for (double y : arr)
            if (y != x)
                return y;
        throw new RuntimeException("no unique number found");
    }


    public static double findUniqShortest(double[] arr) { // O(n * log n)
        Arrays.sort(arr);
        return arr[0] == arr[1] ? arr[arr.length - 1] : arr[0];
    }


    public static double findUniq(double[] arr) { // O(n)
        double r1, r2;
        int c1 = 0;
        int c2 = 0;
        if (arr != null && arr.length > 0) {
            r1 = arr[0];
            r2 = r1;
            for (double x : arr) {
                if (Double.compare(x, r1) == 0) {
                    c1++;
                } else {
                    r2 = x;
                    c2++;
                }
                if (c1 + c2 > 2 && Double.compare(r1, r2) != 0) {
                    if (c1 > c2) {
                        return r2;
                    } else if (c1 < c2) {
                        return r1;
                    }
                }
            }
        }
        return Double.NaN;
    }
}
