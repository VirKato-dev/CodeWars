package codewars.pick.peaks.v0;

import java.util.*;

public class PickPeaks {

    public static void main(String[] args) {
        Map<String, List<Integer>> map = getPeaks(new int[]{3, 2, 3, 6, 4, 1, 2, 3, 2, 1, 2, 2, 2, 1});
        System.out.println(map);
        System.out.println("Over");
    }

    public static Map<String, List<Integer>> getPeaks(int[] arr) {
        Deque<Integer> pos = new ArrayDeque<>();
        Deque<Integer> peak = new ArrayDeque<>();
        Map<String, List<Integer>> map = new HashMap<>();
        map.put("pos", new ArrayList<>());
        map.put("peaks", new ArrayList<>());
        if (arr.length < 1) {
            return map;
        }
        boolean grow = false;
        pos.add(0);
        peak.add(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (peak.peekLast() != arr[i]) {
                if (peak.peekLast() <= arr[i]) {
                    grow = true;
                    pos.removeLast();
                    peak.removeLast();
                } else if (peak.peekLast() > arr[i]) {
                    if (!grow) {
                        pos.removeLast();
                        peak.removeLast();
                    }
                    grow = false;
                }
                pos.addLast(i);
                peak.addLast(arr[i]);
            }
        }
        if (peak.peekLast() >= arr[arr.length - 1]) {
            pos.removeLast();
            peak.removeLast();
        }
        map.put("pos", new ArrayList<>(pos));
        map.put("peaks", new ArrayList<>(peak));
        return map;
    }
}