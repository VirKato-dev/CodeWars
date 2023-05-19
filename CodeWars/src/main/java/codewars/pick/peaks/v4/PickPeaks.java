package codewars.pick.peaks.v4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PickPeaks {
    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        HashMap<String, List<Integer>> map = new HashMap<>();
        map.put("pos", new ArrayList<>());
        map.put("peaks", new ArrayList<>());
        int cur = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > arr[i - 1])
                cur = i;
            else if (arr[i] < arr[cur] && cur != 0) {
                if (!map.get("pos").contains(cur)) {
                    map.get("pos").add(cur);
                    map.get("peaks").add(arr[cur]);
                }
            }
        }
        return map;
    }
}