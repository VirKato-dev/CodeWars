import java.util.*;

/**
 * 3Sum
 * Given an integer array nums,
 * return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.<br>
 * Notice that the solution set must not contain duplicate triplets.
 */
public class Problem15 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
    }


    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Set<List<Integer>> set = new HashSet<>();
            int p1 = 0;
            int p2 = 1;
            int p3 = 2;
            while (p3 < nums.length) {
                if (p1 != p2 && p1 != p3 && p2 != p3) {
                    int v3 = nums[p3];
                    int v2 = nums[p2];
                    int v1 = nums[p1];
                    if (v1 + v2 + v3 == 0) {
                        List<Integer> l = new ArrayList<>(List.of(v1, v2, v3));
                        l.sort(Comparator.naturalOrder());
                        set.add(l);
                    }
                }
                if (++p1 >= p2) {
                    p1 = 0;
                    if (++p2 >= p3) {
                        p2 = p1+1;
                        ++p3;
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }
}

