package a.algo.sort;

import java.util.Arrays;

/**
 * Сортировка пузырьком
 */
public class Bubble {
    public static void main(String[] args) {
        int[] arr = {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] array) {
        for (int rightPadding = 0; rightPadding < array.length; rightPadding++) {
            // после каждого прохода размер неотсортированной части массива уменьшается на 1
            boolean isSorted = true;
            for (int i = 1; i < array.length - rightPadding; i++) {
                if (array[i] < array[i - 1]) {
                    // большие наверх - быстро (последний встретившийся максимальный)
                    // маленькие вниз - медленно (1 шаг на итерацию)
                    int tmp = array[i];
                    array[i] = array[i - 1];
                    array[i - 1] = tmp;
                    isSorted = false;
                }
            }
            if (isSorted) break;
//            System.out.println(Arrays.toString(array));
        }
    }
}
