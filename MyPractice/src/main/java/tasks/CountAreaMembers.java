package tasks;

import java.util.Arrays;

// package whatever; // don't place package name!
// Installed Libraries: JSON-Simple, JUNit 4, Apache Commons Lang3

// Дан массив A длины N.
// Окрестностью элемента массива называется непрерывный максимальный
// подмассив, который содержит этот элемент, и при этом все элементы
// этого подмассива имеют одинаковую четность.
// Для каждого элемента A вывести размер его окрестности

// Пример:
// [2, 1, 5, 3, 2] → [1, 3, 3, 3, 1]

public class CountAreaMembers {
    public static void main (String[] args) {
        int[] array = {2, 1, 5, 3, 2};
        int[] result = solve(array);
        System.out.println(Arrays.toString(result));
    }

    private static int[] solve(int[] array) {
        int[] result = new int[array.length];
        int p1 = 0;
        int count = 1;

        for (int j = 0; j < array.length; j++) {
            if (array[j] % 2 == 0) {
                if (j == 0 || array[j-1] % 2 != 0) {
                    while (p1 < j) {
                        result[p1++] = count;
                    }
                    count = 1;
                } else {
                    count++;
                }
            } else {
                if (j == 0 || array[j-1] % 2 == 0) {
                    while (p1 < j) {
                        result[p1++] = count;
                    }
                    count = 1;
                } else {
                    count++;
                }
            }
        }
        while (p1 < array.length) {
            result[p1++] = count;
        }

        return result;
    }
}