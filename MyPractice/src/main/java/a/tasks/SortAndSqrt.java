package a.tasks;

import java.util.*;

public class SortAndSqrt {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(sqrt(new int[]{-3,-1,0,2,4})));
    }

    private static int[] sqrt(int[] arr) {
        Stack<Integer> res = new Stack<>();
        int pos = 0;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] < 0) {
                res.push(arr[j]*arr[j]);
            } else {
                if (!res.empty() && res.peek() < arr[j]*arr[j]) {
                    arr[pos++] = res.pop();
                    j--;
                } else {
                    arr[pos++] = arr[j]*arr[j];
                }
            }
        }
        while (!res.empty()) {
            arr[pos++] = res.pop();
        }
        return arr;
    }
}
