package com.codewars.pick.peaks.v1;

import java.util.*;

public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> ans = new HashMap<>() {{
            put("pos", new ArrayList<>());
            put("peaks", new ArrayList<>());
        }};
        int posMax = 0;
        boolean matchAsc = false;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] < arr[i]) {
                matchAsc = true;
                posMax = i;
            }
            if (matchAsc && arr[i - 1] > arr[i]) {
                matchAsc = false;
                ans.get("pos").add(posMax);
                ans.get("peaks").add(arr[posMax]);
            }
        }
        return ans;
    }
}