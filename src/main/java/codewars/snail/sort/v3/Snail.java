package codewars.snail.sort.v3;

import java.util.stream.IntStream;

public class Snail {
    public static int[] snail(int[][] array) {
        if (array.length > 0) {
            return IntStream.concat(IntStream.of(array[0]),
                    IntStream.of(snail(rotateArray(array)))).toArray();
        }
        return new int[0];
    }

    public static int[][] rotateArray(int[][] array) {
        int[][] result = new int[array[0].length][array[0].length - (array.length == array[0].length ? 1 : 0)];
        for (int k = 0; k < array[0].length - (array.length == array[0].length ? 1 : 0); k++) {
            for (int i = 0; i < array[0].length; i++) {
                result[i][k] = array[k + 1][array[0].length - i - 1];
            }
        }
        return result;
    }
}