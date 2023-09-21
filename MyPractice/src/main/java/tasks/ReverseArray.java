package tasks;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(reverse(new int[]{1, 2, 3, 4, 5})));
    }

    private static int[] reverse(int[] arr) {
        int left = 0, right = arr.length - 1;
        while (left < right) {
            int tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left++;
            right--;
        }
        return arr;
    }
}
