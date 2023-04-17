package a.tasks;

import java.util.HashMap;
import java.util.Map;

/**
 * Удалить элементы повторяющиеся как минимум k раз
 */
public class ReturnNumsAmountLess {
    public static void main(String[] args) {
        System.out.println(removeFrequentElements(new int[]{1,9,2,6,3,7,2,1,7,1,4}, 2));
    }

    private static int[] removeFrequentElements(int[] arr, int k) {
        Map<Integer,Integer> amounts = new HashMap<>();
        for (int x : arr) {
            amounts.merge(x, 1, Integer::sum);
        }
        return arr;
    }
}
