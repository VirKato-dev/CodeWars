/**
 * Median of Two Sorted Arrays
 */
public class Problem4 {
    public static void main(String[] args) {
        double res;
        assert (res = findMedianSortedArrays(new int[]{1, 3}, new int[]{2})) == 2 : "answer = " + res;
        assert (res = findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4})) == 2.5 : "answer = " + res;

    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int[] merged = new int[len];
        int p1 = 0, p2 = 0, p3 = 0;
        int n1, n2;

        do {
            n1 = p1 >= nums1.length ? Integer.MAX_VALUE : nums1[p1];
            n2 = p2 >= nums2.length ? Integer.MAX_VALUE : nums2[p2];

            if (n1 < n2) p1++;
            else p2++;

            merged[p3++] = Math.min(n1, n2);
        } while (p1 < nums1.length || p2 < nums2.length);

        if (merged.length % 2 == 0) {
            return (merged[len / 2 - 1] + merged[len / 2]) / 2d;
        }
        return merged[len / 2];
    }
}
