package p674_LongestContinuousIncreasingSubsequence;

import java.util.ArrayList;
import java.util.List;

public class SolutionWrong {

    public static void main(String[] args) {
        System.out.println(new SolutionWrong().findLengthOfLCIS(new int[]{3, 5, 4, 1, 7, 2}));
    }


    public int findLengthOfLCIS(int[] nums) {
        List<Range> ranges = new ArrayList<>();
        for (int num : nums) {
            boolean found = false;
            for (Range range : ranges) {
                if (range.start - 1 == num || range.end + 1 == num) {
                    found = true;
                    if (range.start - 1 == num) {
                        range.start--;
                        break;
                    } else {
                        range.end++;
                        break;
                    }
                }
            }
            if (!found) ranges.add(new Range(num, num));
        }
        System.out.println(ranges);

        int result = 0;

        List<Range> mergedRanges = new ArrayList<>();
        for (Range range : ranges) {
            boolean found = false;
            for (Range mergedRange : mergedRanges) {
                if (range.isLeftNeighbor(mergedRange)) {
                    found = true;
                    mergedRange.start = range.start;
                    result = Math.max(result, mergedRange.getInterval());
                    break;
                } else if (range.isRightNeighbor(mergedRange)) {
                    found = true;
                    mergedRange.end = range.end;
                    result = Math.max(result, mergedRange.getInterval());
                    break;
                }
            }
            if (!found) {
                mergedRanges.add(range);
                result = Math.max(result, range.getInterval());
            }
        }
        System.out.println(mergedRanges);

        return result;
    }


    public static class Range {
        public int start;
        public int end;

        public Range(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public boolean isLeftNeighbor(Range other) {
            return Math.abs(end - other.start) == 1;
        }

        public boolean isRightNeighbor(Range other) {
            return Math.abs(start - other.end) == 1;
        }

        public int getInterval() {
            return end - start + 1;
        }

        @Override
        public String toString() {
            return "(" + start + ", " + end + ")";
        }
    }
}
