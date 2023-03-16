package a.algo.sort;

import a.threads.MeasureTime;

public class Test {

    public static void main(String[] args) {
        int testLen = 100000;
        int[] arr1 = new int[testLen];
        System.out.println("----- Случайный массив -----");
        for (int i = 0; i < testLen; i++) {
            arr1[i] = (int) Math.round(Math.random() * testLen);
        }

        startTest1(arr1);
    }


    private static void startTest1(int[] arr) {
        int[] arr1 = arr.clone();
        MeasureTime.measureTime("Быстрая сортировка", () -> Quick.quickSort(arr1), arr1);
        int[] arr2 = arr.clone();
        MeasureTime.measureTime("Сортировка слиянием", () -> Merge.mergeSort(arr2), arr2);
        int[] arr3 = arr.clone();
        MeasureTime.measureTime("Сортировка выбором", () -> Select.selectSort(arr3), arr3);
        int[] arr4 = arr.clone();
        MeasureTime.measureTime("Сортировка пузырьком", () -> Bubble.bubbleSort(arr4), arr4);
    }


    private static void startTests2(int[] arr) {
        System.out.println("Быстрая сортировка:");
        measureTime(() -> Quick.quickSort(arr.clone()));

        System.out.println("Сортировка слиянием:");
        measureTime(() -> Merge.mergeSort(arr.clone()));

        System.out.println("Сортировка выбором:");
        measureTime(() -> Select.selectSort(arr.clone()));

        System.out.println("Сортировка пузырьком:");
        measureTime(() -> Bubble.bubbleSort(arr.clone()));
    }


    private static void measureTime(Runnable action) {
        long begin = System.currentTimeMillis();
        action.run();
        long duration = System.currentTimeMillis() - begin;
        System.out.println("Затрачено время: " + duration + "ms\n");
    }
}
