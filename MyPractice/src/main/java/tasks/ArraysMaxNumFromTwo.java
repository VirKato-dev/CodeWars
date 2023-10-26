package tasks;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ArraysMaxNumFromTwo {
    private static int[] arr1 = {1, 2, 2, 3, 3};
    private static int[] arr2 = {2, 2, 3, 4};

    public static void main(String[] args) {
        System.out.println(findMaxFromRepeated());
        System.out.println(findMaxFromRepeated2());
    }

    private static int findMaxFromRepeated() {
        int max = Integer.MIN_VALUE;
        Set<Integer> unique = new HashSet<>();
        // по 2-м массивам сразу идём без создания общего
        for (int j = 0; j < arr1.length + arr2.length; j++) {
            int current;
            // берём число из соответствующего массива
            if (j < arr1.length) {
                current = arr1[j];
            } else {
                current = arr2[j - arr1.length];
            }
            // если число ранее встречалось, то сравниваем с максимальным
            if (!unique.add(current) && current > max) {
                max = current;
            }
        }
        return max;
    }

    private static int findMaxFromRepeated2() {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        Set<Integer> set = new HashSet<>();
        // по 2-м массивам сразу идём без создания общего
        for (int j = 0; j < arr1.length + arr2.length; j++) {
            int current;
            // берём число из соответствующего массива
            if (j < arr1.length) {
                current = arr1[j];
            } else {
                current = arr2[j - arr1.length];
            }
            // если число ранее встречалось, то сравниваем с максимальным
            if (!set.add(current)) {
                queue.add(current);
            }
        }
        return queue.poll();
    }
}
