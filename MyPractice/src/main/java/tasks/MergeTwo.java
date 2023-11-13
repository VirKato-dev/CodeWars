package tasks;

import java.util.Arrays;

public class MergeTwo {
    public static void main(String[] args) {
        int[] a = {4, 5, 7, 8};
        int[] a2 = {3, 5, 6};
        System.out.println(Arrays.toString(merge(a, a2)));
        System.out.println(Arrays.toString(merge2(a, a2)));
        System.out.println(Arrays.toString(merge3(a, a2)));
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

    private static int[] merge3(int[] a1, int[] a2) {
        int idx1 = 0, idx2 = 0;
        int[] a3 = new int[a1.length + a2.length];
        for (int j = 0; j < a1.length + a2.length; j++) {

            int comp;
            if (idx1 >= a1.length) {
                comp = 1;
            } else if (idx2 >= a2.length) {
                comp = -1;
            } else {
                comp = a1[idx1] - a2[idx2];
            }

            if (comp < 0) {
                a3[j] = a1[idx1++];
            } else {
                a3[j] = a2[idx2++];
            }
        }
        return a3;
    }
}
