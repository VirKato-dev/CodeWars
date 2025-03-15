package p674_LongestContinuousIncreasingSubsequence;

public class Solution {
    public static void main(String[] args) {
//        System.out.println(new Solution().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new Solution().findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }


    public int findLengthOfLCIS(int[] nums) {
        int seq = 0;
        int prev = Integer.MIN_VALUE;
        int result = 1;

        for (int num : nums) {
            if (prev < num) {
                seq++;
                result = Math.max(seq, result);
            } else {
                seq = 1;
            }
            prev = num;
        }

        return result;
    }
}
