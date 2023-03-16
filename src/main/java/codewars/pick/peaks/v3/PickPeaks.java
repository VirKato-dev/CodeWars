package codewars.pick.peaks.v3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Map<String, List<Integer>> result = new HashMap<>();
        result.put("pos", new ArrayList<>());
        result.put("peaks", new ArrayList<>());
        IntStream.range(1, arr.length - 1)
                .filter(i -> isPeak(arr, i))
                .forEach(i -> {
                    result.get("pos").add(i);
                    result.get("peaks").add(arr[i]);
                });
        return result;
    }

    private static boolean isPeak(int[] arr, int index) {
        if (arr[index] <= arr[index - 1]) return false;
        for (int i = index + 1; i < arr.length; i++) {
            if (arr[index] > arr[i]) return true;
            else if (arr[index] < arr[i]) return false;
        }
        return false;
    }
}