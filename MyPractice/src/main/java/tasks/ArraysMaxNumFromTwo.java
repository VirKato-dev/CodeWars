package tasks;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class ArraysMaxNumFromTwo {
    private static int[] arr1 = {1, 2, 2, 3, 3};
    private static int[] arr2 = {2, 2, 3, 4};

    public static void main(String[] args) {
        System.out.println(findMaxFromRepeating());
        System.out.println(findMaxFromRepeating2());
    }

    private static int findMaxFromRepeating() {
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

    private static int findMaxFromRepeating2() {
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

    /**
     * Если массивы отсортированы по возрастанию.
     *
     * @return максимально из повторяющихся либо -1 при отсутствии повторяющихся
     */
    private static int findMaxFromRepeating3() {
        // O(n/2) = O(n)
        // в лучшем случае число найдётся на первой итерации
        Set<Integer> set = new HashSet<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int len1 = arr1.length, len2 = arr2.length;
        int maxLength = Math.max(len1, len2);
        // по двум массивам одновременно
        for (int j = 0; j < maxLength; j++) {
            if (len1 - 1 - j >= 0) { // пока массив не закончился
                if (!set.add(arr1[len1 - 1 - j])) {
                    queue.add(arr1[len1 - 1 - j]);
                }
            }
            if (len2 - 1 - j >= 0) { // пока массив не закончился
                if (!set.add(arr2[len2 - 1 - j])) {
                    queue.add(arr2[len2 - 1 - j]);
                }
            }
            if (!queue.isEmpty()) { // первое же повторяющееся число является максимальным
                return queue.poll();
            }
        }
        return -1;
    }
}
