package nolimit.task4;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * У Кости есть бумажка, на которой написано n чисел.
 * Также у него есть возможность не больше, чем k раз, взять любое число с бумажки,
 * после чего закрасить одну из старых цифр, а на ее месте написать новую произвольную цифру.
 * <p>
 * На какое максимальное значение Костя сможет увеличить сумму всех чисел на листочке?
 */
public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
        Scanner in = new Scanner("5 2\n 1 2 1 3 5"); // 16
//        Scanner in = new Scanner("3 1\n 99 5 85"); // 10
//        Scanner in = new Scanner("1 10\n 9999"); // 0
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int j = 0; j < n; j++) {
            arr[j] = in.nextInt();
        }
        System.out.println(option1(k, arr));
    }

    private static long option1(int k, int[] arr) {
        long result = 0;
        Queue<Long> queue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int num : arr) {
            int step = 1;
            while (num > 0) {
                long tmp = 9 - (num % 10);
                queue.add(tmp * step);
                num /= 10;
                step *= 10;
            }
        }
        while (k > 0 && !queue.isEmpty()) {
            result += queue.poll();
            k--;
        }
        return result;
    }
}
