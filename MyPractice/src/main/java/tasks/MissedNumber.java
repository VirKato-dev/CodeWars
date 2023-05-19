package tasks;

import java.util.Arrays;

public class MissedNumber {

    public static void main(String[] args) {
        int[] arr = {1, 4, 3, 2};
        System.out.println(findMissedNumber(arr)); // ответ 0
    }

    private static int findMissedNumber(int[] arr) {
        int actualSum = Arrays.stream(arr).sum();
        int expectedSum = arr.length * (arr.length + 1) / 2;
        return expectedSum - actualSum;
    }
}
