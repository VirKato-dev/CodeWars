package tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// объединить интервалы
// input: [ {1,4},{2,5},{7,9} ]
// output: [ {1,5},{7,9} ]

//fixme не реализовано
public class MergeRanges {
    public static void main(String[] args) {
        List<Integer[]> intervals = Arrays.asList(
                new Integer[]{1, 4},
                new Integer[]{2, 5},
                new Integer[]{7, 9}
        );
        System.out.println(mergeIntervals(intervals));
    }

    public static List<Integer[]> mergeIntervals(List<Integer[]> intervals) {

        //  здесь будет проверка на null
        // делаем копию листа
        intervals.sort(Comparator.comparingInt(x -> x[0]));

        List<Integer[]> merged = new ArrayList<>();
        intervals.forEach(interval -> {
            if (merged.isEmpty() || merged.get(merged.size() - 1)[0] < interval[0]) {
                merged.add(interval);
            } else {
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], interval[1]);
            }
        });

        return merged;
    }
}
