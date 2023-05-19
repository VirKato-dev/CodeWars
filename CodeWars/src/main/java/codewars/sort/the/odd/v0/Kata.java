package codewars.sort.the.odd.v0;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Kata {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortArray(new int[]{5, 3, 2, 8, 1, 4})));
    }

    public static int[] sortArray(int[] array) {
        Queue<Integer> queue = new ArrayDeque<>(Arrays.stream(array).filter(x -> x % 2 != 0).boxed().sorted().toList());
        int[] res = new int[array.length];
        for (int i = 0; i < array.length; i++) {
            int v = array[i];
            if (v % 2 != 0) v = queue.poll();
            res[i] = v;
        }
        return res;
    }
}