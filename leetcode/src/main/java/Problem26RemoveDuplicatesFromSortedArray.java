/**
 * Given an integer array nums sorted in non-decreasing order,
 * remove the duplicates in-place such that each unique element appears only once.
 * The relative order of the elements should be kept the same.
 * Then return the number of unique elements in nums.
 * <br>
 * Consider the number of unique elements of nums to be k,
 * to get accepted, you need to do the following things:
 * <br>
 * Change the array nums such that the first k elements
 * of nums contain the unique elements in the order they were present in nums initially.
 * The remaining elements of nums are not important as well as the size of nums.
 * <br>
 * Return k.
 */
public class Problem26RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(new SolutionMy().removeDuplicates(new int[]{1, 1, 2})); // 2
        System.out.println(new SolutionMy().removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4})); // 5
    }


    static class SolutionMy {
        public int removeDuplicates(int[] nums) {
            int j = 0;
            int offset = 0;
            Integer prev = null;
            while (j + offset < nums.length) {
                nums[j] = nums[j + offset];
                if (prev != null && prev == nums[j + offset]) {
                    offset++;
                } else {
                    prev = nums[j + offset];
                    j++;
                }
            }
            return nums.length - offset;
        }
    }


    static class SolutionFast {
        public int removeDuplicates(int[] nums) {
            int uniqueVal = nums[0];
            int k = 1;
            for (int el : nums) {
                if (uniqueVal == el) continue;
                nums[k++] = uniqueVal = el;
            }
            return k;
        }
    }


    static class SolutionLowMemory {
        public int removeDuplicates(int[] nums) {
            int nextIndex = 1;
            for (int i = 0; i < nums.length - 1; i++) {
                if (nums[i] < nums[i + 1]) {
                    nums[nextIndex] = nums[i + 1];
                    nextIndex++;
                }
            }
//            System.gc();
            return nextIndex;
        }
    }
}
