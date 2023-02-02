package com.codewars.pick.peaks.v2;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        List<Integer> posList = new ArrayList<>();
        List<Integer> peakList = new ArrayList<>();
        int n = arr.length;
        int i = 0;
        int xi = n > 0 ? arr[0] : 0;
        for (int j = 1; j < n; j++) {
            int xj = arr[j];
            int d = xj - xi;
            if (d == 0)
                continue;
            if (d > 0)
                i = j;
            else if (i > 0) {
                posList.add(i);
                peakList.add(xi);
                i = 0; // indicates fall
            }
            xi = xj;
        }
        return Map.of("pos", posList, "peaks", peakList);
    }
}