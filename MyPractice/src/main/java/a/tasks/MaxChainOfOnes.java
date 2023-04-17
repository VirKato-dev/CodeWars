package a.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Дан массив из 0 и 1. Надо вывести максимальную последовательность 1 в этом массиве,
 * при условии, что она может быть разделена только одним 0.
 * Пример вывода: 1,0,1,1,1,0,0,1,1,1 -> 4.
 */
public class MaxChainOfOnes {
    public static void main(String[] args) {
        System.out.println("4 == " + findMaxOnes2(new int[]{1, 0, 1, 1, 1, 0, 0, 1, 1, 1}));
        System.out.println("6 == " + findMaxOnes2(new int[]{1, 0, 0, 1, 1, 1, 0, 1, 1, 1}));
        System.out.println("5 == " + findMaxOnes2(new int[]{0, 1, 0, 1, 1, 1, 0, 1, 1, 0}));
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
        for (int j : arr) {
            if (j == 1) {
                count++;
            } else if (!zeroFound) {
                zeroFound = true;
            } else {
                maxCount = Math.max(maxCount, count);
                count = 0;
                zeroFound = false;
            }
        }
        return Math.max(maxCount, count);
    }


    private static int findMaxOnes3(int[] arr) {
        int res = 0;
        String str = Arrays.toString(arr).replaceAll("\\D", "");
        Pattern pattern = Pattern.compile("((1+01+)|(1+))");
        Matcher matcher = pattern.matcher(str);
        while (matcher.find()) {
            res = Math.max(matcher.group().replaceAll("0", "").length(), res);
        }
        return res;
    }
}
