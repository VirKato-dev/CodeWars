package tasks;

import java.util.Arrays;

public class MergeTwo {
    public static void main(String[] args) {
        int[] a = {4, 5, 7, 8};
        int[] a2 = {3, 5, 6};
        System.out.println(Arrays.toString(merge2(a, a2)));
    }

    private static int[] merge(int[] a, int[] a2) {
        int[] res = new int[a.length + a2.length];
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < a.length & j < a2.length) {
            res[k++] = a[i] < a2[j] ? a[i++] : a2[j++];
        }
        while (i < a.length) {
            res[k++] = a[i++];
        }
        while (j < a2.length) {
            res[k++] = a2[j++];
        }

        return res;
    }


    private static int[] merge2(int[] a, int[] a2) {
        int[] res = new int[a.length + a2.length];
        int i = 0;
        int j = 0;

        while (i < a.length & j < a2.length) {
            res[i + j] = a[i] < a2[j] ? a[i++] : a2[j++];
        }
        while (i < a.length) {
            res[i + j] = a[i++];
        }
        while (j < a2.length) {
            res[i + j] = a2[j++];
        }

        return res;
    }


    private static int[] merge3(int[] a, int[] b) {
        int[] res = new int[a.length + b.length];
        int i = 0;
        int j = 0;

        while (i < a.length || j < b.length) {
            res[i + j] = a[i] < b[j] ? a[i++] : b[j++];
        }
        while (i < a.length) {
            res[i + j] = a[i++];
        }
        while (j < b.length) {
            res[i + j] = b[j++];
        }

        return res;
    }


}
