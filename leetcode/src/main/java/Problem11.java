/**
 * Container With Most Water
 * You are given an integer array height of length n.
 * There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).<br>
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.<br>
 * Return the maximum amount of water a container can store.<br>
 * Notice that you may not slant the container.
 * <br><br>
 * Input: height = [1,8,6,2,5,4,8,3,7]<br>
 * Output: 49<br>
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].<br>
 * In this case, the max area of water (blue section) the container can contain is 49.
 */
public class Problem11 {
    public static void main(String[] args) {
        int res;
        assert (res = maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7})) == 49 : "{1, 8, 6, 2, 5, 4, 8, 3, 7} = " + res;
        assert (res = maxArea(new int[]{1, 1})) == 1 : "{1, 1} = " + res;
        assert (res = maxArea(new int[]{2, 3, 4, 5, 18, 17, 6})) == 17 : "{2, 3, 4, 5, 18, 17, 6} = " + res;
    }

    // ------- Best

    public static int maxArea(int[] height) {
        int max = 0, l = 0, r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;
    }

    // ------- Other

    public static int maxArea2(int[] height) {
        int area = 0;
        int i = 0;
        int j = height.length - 1;
        while (i < j) {
            int heightVar = (height[i] > height[j] ? height[j] : height[i]);
            int areaVar = heightVar * (j - i);
            if (areaVar > area)
                area = areaVar;
            while (height[i] <= heightVar && i < j) i++;
            while (height[j] <= heightVar && i < j) j--;
        }
        return area;
    }

    // ------- My

//    public static int maxArea(int[] height) { // не для больших массивов
//        int max = 0;
//        for (int l = 0; l < height.length - 1; l++) {
//            for (int r = l + 1; r < height.length; r++) {
//                max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
//            }
//        }
//        return max;
//    }
}
