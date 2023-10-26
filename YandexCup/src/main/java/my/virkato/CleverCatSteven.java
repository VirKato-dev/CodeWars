package my.virkato;

import java.util.Scanner;

// 5
// 1 2 3 1 4
// 1

// (123) 1 4 - есть 1

// 5
// 1 2 3 2 3
// 3

// (123) (2) (3) - есть 1 2 3

// 5
// 3 3 4 5 3
// 0

// 3 3 4 5 3 - нет 1

public class CleverCatSteven {

    public static void main(String[] args) {
//        count();
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println("" + count(nums, 0, 1, 0));
    }

    private static int count(int[] nums, int pos, int init, int count) {
        return 0;
    }


    public static void count() {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int last = 0;
        int count = 0;
        boolean good = true;
        for (int i = 0; i < len; i++) {
            int num = in.nextInt();
            if (last > 0) {
                if (num < last || i == len - 1) {
                    if (good) count++;
                    good = true;
                }
                if (num != last + 1) {
                    good = false;
                }
            }
            last = num;
        }
        System.out.println("" + count);
    }
}
