package contest2024.task2;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner("31\nYou_know#how_to_solve#this_task");
        int len = in.nextInt();
        String text = in.next();
        int[] res = getResult(len, text);
        System.out.println(res[0] + " " + res[1]);
    }

    public static int[] getResult(int len, String text) {
        int[] result = new int[2];
        result[0] = Integer.MAX_VALUE;
        String[] lines = text.substring(0, len).split("#");
        for (String line : lines) {
            if (result[0] > line.length()) result[0] = line.length();
            if (result[1] < line.length()) result[1] = line.length();
        }
        return result;
    }
}
