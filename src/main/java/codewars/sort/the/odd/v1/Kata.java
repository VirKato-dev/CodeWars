package codewars.sort.the.odd.v1;

import java.util.Arrays;

public class Kata {
    public static int[] sortArray(final int[] array) {
        final int[] sortedOdd = Arrays.stream(array).filter(e -> e % 2 == 1).sorted().toArray();
        for (int j = 0, s = 0; j < array.length; j++) {
            if (array[j] % 2 == 1) array[j] = sortedOdd[s++];
        }
        return array;
    }
}