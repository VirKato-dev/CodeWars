package contest2024.task3;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner("3\n1 2 3");
        Scanner in = new Scanner("4\n0 1 1 0");
        int count = in.nextInt();
        int[] heights = new int[count];
        for (int j = 0; j < count; j++) {
            heights[j] = in.nextInt();
        }
        System.out.println(getResult(heights));
    }

    public static double getResult(int[] h) {
        double middle = 0;
        double half = 0;
        double full = 0;
        for (int k : h) {
            middle += k;
        }
        middle = middle / h.length;
        for (int j = 0; j < h.length - 1; j++) {
            if (h[j] != h[j + 1]) {
                half += Math.abs(h[j]-middle) / 2;
            } else {
                full += middle;
            }
        }
        return (full - half) / 2;
    }
}
