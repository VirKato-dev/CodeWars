import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1207UniqueNumberOfOccurrences {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        System.out.println(solution.uniqueOccurrences(new int[]{1, 2}));
        System.out.println(solution.uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    static class Solution {
        public boolean uniqueOccurrences(int[] arr) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int x : arr) {
                map.merge(x, 1, Integer::sum);
            }
            Set<Integer> set = new HashSet<>(map.values());
            return set.size() == map.size();
        }
    }


    static class SolutionFast {
        public boolean uniqueOccurrences(int[] arr) {
            int min = 1000, max = -1000;
            for (int i : arr) {
                if (i > max) max = i;
                if (i < min) min = i;
            }
            int size = max - min + 1;
            int offset = -min;

            short[] counts = new short[size];
            short maxCount = 0;
            for (int i : arr) {
                counts[i + offset]++;
                if (maxCount < counts[i + offset]) {
                    maxCount = counts[i + offset];
                }
            }
            boolean[] unique = new boolean[maxCount];
            for (short i : counts) {
                if (i != 0) {
                    if (unique[i - 1]) {
                        return false;
                    }
                    unique[i - 1] = true;
                }
            }
            return true;
        }
    }
}
