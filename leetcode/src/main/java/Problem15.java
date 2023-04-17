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
        Solution2 solution = new Solution2();
        System.out.println(solution.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(solution.threeSum(new int[]{0, 1, 1}));
        System.out.println(solution.threeSum(new int[]{0, 0, 0}));
    }


    /**
     * My method
     */
    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            Set<List<Integer>> set = new HashSet<>();
            for (int p1 = 0; p1 < nums.length - 2; p1++) {
                int p2 = p1 + 1;
                int p3 = nums.length - 1;
                while (p2 < p3) {
                    int sum = nums[p1] + nums[p2] + nums[p3];
                    if (sum == 0) {
                        set.add(List.of(nums[p1], nums[p2], nums[p3]));
                        p2++;
                        p3--;
                    } else if (sum < 0) {
                        p2++;
                    } else {
                        p3--;
                    }
                }
            }
            return new ArrayList<>(set);
        }
    }


    /**
     * Fast method
     */
    static class Solution2 {
        List<List<Integer>> ans = new ArrayList<>();

        public List<List<Integer>> threeSum(int[] nums) {
            Arrays.sort(nums);
            for (int i = 0; i < nums.length; i++) {
                if (i == 0 || nums[i] != nums[i - 1])
                    twoSumSort(i + 1, nums.length - 1, -nums[i], nums);
            }
            return ans;
        }

        public void twoSumSort(int i, int j, int target, int[] nums) {
            int a = nums[i - 1];
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(a);
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    ans.add(temp);
                    while (i < j && nums[i] == nums[i + 1]) i++;
                    while (i < j && nums[j] == nums[j - 1]) j--;
                    i++;
                    j--;
                } else if (nums[i] + nums[j] > target)
                    j--;
                else
                    i++;
            }
        }
    }
}

