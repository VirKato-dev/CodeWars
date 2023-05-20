public class Problem27RemoveElement {

    public static void main(String[] args) {
        System.out.println(new SolutionMy().removeElement(new int[]{3, 2, 2, 3}, 3));
        System.out.println(new SolutionMy().removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2));
    }


    static class SolutionMy {
        public int removeElement(int[] nums, int val) {
            int k = 0;
            for (int x : nums) {
                if (x != val) nums[k++] = x;
            }
            return k;
        }
    }


    static class SolutionLowMemory {
        public int removeElement(int[] nums, int val) {
            int i = 0;
            int j = 0;
            while (j < nums.length) {
                if (nums[j] != val) {
                    nums[i] = nums[j];
                    i++;
                }
                j++;
            }
            return i;
        }
    }
}
