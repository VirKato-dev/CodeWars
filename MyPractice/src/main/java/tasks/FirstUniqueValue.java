package tasks;

import java.util.*;

public class FirstUniqueValue {
    public static void main(String[] args) {
        System.out.println(find(new int[]{9, 4, 9, 5, -8, 7, 4, 5, 6, 7}));
        System.out.println(getFirstUniqueElement(new int[]{9, 4, 9, 5, -8, 7, 4, 5, 6, 7}));
    }


    private static Integer find(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int x : arr) map.merge(x, 1, Integer::sum);
        for (int x : arr) if (map.get(x) == 1) return x;
        return null;
    }


    public static Integer getFirstUniqueElement(int[] array) {
        return Arrays.stream(array).boxed()
                .filter(
                        i -> Arrays.stream(array)
                                .filter(j -> i == j)
                                .count() == 1
                )
                .findFirst()
                .get();
    }
}
