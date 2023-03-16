package a.algo.sort;

import java.util.Arrays;

/**
 * Сортировка перестановкой
 */
public class Select {
    public static void main(String[] args) {
        int[] arr = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] array) {
        for (int step = 0; step < array.length; step++) {
            int index = min(array, step);
            int tmp = array[step];
            array[step] = array[index];
            array[index] = tmp;
        }
    }

    private static int min(int[] array, int start) {
        int minIndex = start;
        int minValue = array[start];
        for (int i = start + 1; i < array.length; i++) {
            if (array[i] < minValue) {
                minValue = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
