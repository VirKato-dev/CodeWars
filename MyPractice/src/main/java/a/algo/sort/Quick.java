package a.algo.sort;

import java.util.Arrays;

/**
 * Быстрая сортировка
 */
public class Quick {
    public static void main(String[] args) {
        int[] arr = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(Arrays.toString(arr));
        System.out.println(Arrays.toString(quickSort(arr)));
    }

    public static int[] quickSort(int[] array) {
        sort(array, 0, array.length-1);
        return array;
    }

    private static void sort(int[] array, int from, int to) {
        if (from < to) {
            int divideIndex = partition(array, from, to); // раскидали исходный массив
            sort(array, from, divideIndex - 1); // раскидали левый подмассив
            sort(array, divideIndex, to); // раскидали правый подмассив
        }
    }

    private static int partition(int[] arr, int from, int to) {
        int pivot = arr[from + (to - from) / 2]; // выбрать значение среднего элемента
        while (from <= to) {
            while (arr[from] < pivot) from++;
            while (arr[to] > pivot) to--;
            if (from <= to) {
                swap(arr, from, to, arr[from], arr[to]);
                from++;
                to--;
            }
        }
        return from;
    }

    private static void swap(int[] a, int l, int r, int al, int ar) {
        a[r] = al;
        a[l] = ar;
    }
}
