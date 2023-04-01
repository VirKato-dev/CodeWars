package a.algo;

import java.util.Arrays;

public class ZeroToTail {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(zeroToTail(new int[]{1, 2, 0, 3, 0, 4})));
    }

    private static int[] zeroToTail(int[] arr) {
        int count = 0; // кол-во нулей встретили
        int j = 0; // обрабатываемая позиция в массиве
        while (j + count < arr.length) { // пока не кончился массив
            if (arr[j + count] == 0) {
                count++; // перескакиваем 0
            } else {
                arr[j] = arr[j + count]; // пишем не 0
                j++;
            }
        }
        while (count > 0) { // дописываем 0
            arr[arr.length - count--] = 0;
        }
        return arr;
    }
}
