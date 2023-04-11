package a.tasks;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Дан массив из 0 и 1. Надо вывести максимальную последовательность 1 в этом массиве,
 * при условии, что она может быть разделена только одним 0.
 * Пример вывода: 1,0,1,1,1,0,0,1,1,1 -> 4.
 */
public class Test5 {
    public static void main(String[] args) {
        System.out.println("4 == " + findMaxOnes3(new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 1}));
        System.out.println("6 == " + findMaxOnes3(new int[]{1, 0, 0, 1, 1, 1, 0, 1, 1, 1}));
    }


    private static int findMaxOnes(int[] arr) {
        List<Integer> list = new ArrayList<>();
        int start = 0;
        while (start < arr.length) {
            while (start < arr.length && arr[start] == 0) {
                start++;
            }
            int pos = start;
            int zero = 0;
            int count = 0;
            while (pos < arr.length && zero < 2) {
                if (arr[pos++] == 0) zero++;
                else count++;
            }
            list.add(count);
            start++;
        }
        list.sort(Comparator.reverseOrder());
        return list.size() > 0 ? list.get(0) : -1;
    }


    private static int findMaxOnes2(int[] arr) {
        int count = 0;
        int maxCount = 0;
        boolean zeroFound = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else if (!zeroFound) {
                zeroFound = true;
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
                i--;
                zeroFound = false;
            }
        }

        return Math.max(maxCount, count);
    }


    private static int findMaxOnes3(int[] arr) {
        int count = 0;
        int maxCount = 0;
        boolean zeroFound = false;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                count++;
            } else if (!zeroFound) {
                zeroFound = true;
                count++;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
                i--;
                zeroFound = false;
            }
        }

        return Math.max(maxCount, count);
    }
}
