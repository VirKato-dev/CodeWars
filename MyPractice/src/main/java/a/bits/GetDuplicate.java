package a.bits;

public class GetDuplicate {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 5};
        System.out.println(getDuplicate(nums));
    }

    private static int getDuplicate(int[] nums) {
        int res = 0;
        for (int x : nums) {
            res |= x;
        }
        for (int x : nums) {
            res ^= x;
        }
        for (int x : nums) {
            res &= x;
        }
        return res;
    }
}
