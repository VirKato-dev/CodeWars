package a.algo;

public class BinarySearch {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}, 10));
    }

    private static int search(int[] arr, int x) {
        int left = 0, right = arr.length - 1;
        while (left <= right) {
            int middle = left + (right - left) / 2;
            if (arr[middle] < x) {
                left = middle + 1;
            } else if (arr[middle] > x) {
                right = middle - 1;
            } if (arr[middle] == x) {
                return middle;
            }
        }
        return -1;
    }
}
