public class Problem35SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 5)); // 2
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 2)); // 1
        System.out.println(searchInsert(new int[]{1, 3, 5, 6}, 7)); // 4
    }


    public static int searchInsert(int[] nums, int target) {
        int left = 0, rite = nums.length-1;
        int nearD = Integer.MAX_VALUE;
        int nearM = rite;

        while (left <= rite) {
            int mid = left + (rite - left) / 2;
            int d = nums[mid] - target;
            if (d >= 0 && d < nearD) {
                nearD = d;
            }
            nearM = d < 0 ? mid + 1 : mid;
            if (target < nums[mid]) {
                rite = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                break;
            }
        }
        return nearM;
    }


    public static int searchInsertLowMemory(int[] nums, int target) {
        int cpt = 0;
        while (cpt < nums.length) {
            if (nums[cpt] == target) {
                System.gc();
                return cpt;
            }
            if (nums[cpt] > target) {
                System.gc();
                return cpt--;
            }
            cpt++;
        }
        System.gc();
        return cpt;
    }
}
