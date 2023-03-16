package a.algo.bigo;

import java.util.Arrays;

public class On_fact {
    public static void main(String[] args) {
        // Пример вызова функции permute
        int[] arr = {1, 2, 3};
        permute(arr, 0);
    }

    /**
     * Алгоритм перебора всех перестановок элементов массива
     * является примером алгоритма со сложностью O(n!),
     * где n - количество элементов в массиве.
     * Пример рекурсивной реализации этого алгоритма
     *
     * @param arr
     * @param k
     */
    private static void permute(int[] arr, int k) {
        if (k == arr.length - 1) {
            System.out.println(Arrays.toString(arr).replaceAll("[,\\[\\]]", ""));
        } else {
            for (int i = k; i < arr.length; i++) {
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                System.out.printf(">> i%d k%d %s%n", i, k, Arrays.toString(arr));
                permute(arr, k + 1);
                temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                System.out.printf("<< i%d k%d %s%n", i, k, Arrays.toString(arr));
            }
        }
    }
}
/*
i0 k0 123    i1 k1 123
             i2 k1 132
i1 k0 213    i1 k1 213
             i2 k1 231
i2 k0 321    i1 k1 321
             i2 k1 312
 */