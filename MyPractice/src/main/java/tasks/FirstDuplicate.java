package tasks;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FirstDuplicate {

    public static void main(String[] args) {
        System.out.println(findFirstNonUnique(new int[]{1, 2, 2, 1}));
    }

    // возвращает 1
    private static int findFirstNonUnique(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i : arr) {
            countMap.merge(i, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> e : countMap.entrySet()) {
            if (e.getValue() > 1) return e.getKey();
        }
        return -1; // если уникальное значение не найдено
    }

    // возвращает 2
    private static int findFirstDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int j : arr) {
            if (set.contains(j)) {
                return j;
            } else {
                set.add(j);
            }
        }
        return -1; // если нет повторяющихся элементов
    }
}
