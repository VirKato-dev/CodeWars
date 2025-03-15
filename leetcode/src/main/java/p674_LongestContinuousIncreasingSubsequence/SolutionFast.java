package p674_LongestContinuousIncreasingSubsequence;

public class SolutionFast {
    public static void main(String[] args) {
        System.out.println(new SolutionFast().findLengthOfLCIS(new int[]{1, 3, 5, 4, 7}));
        System.out.println(new SolutionFast().findLengthOfLCIS(new int[]{1, 3, 5, 7}));
    }


    public int findLengthOfLCIS(int[] nums) {
        return maxi(nums, 0, nums.length);
    }


    static int maxi(int[] nums, int s, int e) {
        if (s >= e) return 0;
        int c = 1;
        for (int i = s; i < e - 1; i++) {
            if (nums[i + 1] > nums[i]) c++;
            else {
                c = Math.max(c, maxi(nums, i + 1, e));
                break;
            }
        }
        return c;
    }
}
