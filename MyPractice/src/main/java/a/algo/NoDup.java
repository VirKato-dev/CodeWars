package a.algo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class NoDup {
    public static void main(String[] args) {
        System.out.println(res1(new int[]{1,2,3,4}));
    }


    public static boolean res1(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (Integer i : arr) {
            if (!set.add(i)) return true;
        }
        return false;
    }


    public static boolean result(int[] arr) {
        Map<Integer, Object> map = new HashMap<>();
        for (int i=0; i<arr.length; i++) {
            if (map.containsKey(arr[i])) {
                return true;
            } else {
                map.put(arr[i], "");
            }
        }
        return false;
    }
}
