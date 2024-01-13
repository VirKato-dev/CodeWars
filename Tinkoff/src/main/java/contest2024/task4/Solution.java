package contest2024.task4;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        Scanner in = new Scanner("6\n30 30 20 11 12 1");
        Scanner in = new Scanner("8\n9 11 10 1 3 5 4 4");
        int count = in.nextInt();
        Set<Integer> set = new TreeSet<>();
        for (int j = 0; j < count; j++) {
            set.add(in.nextInt());
        }
//        StringBuilder sb = new StringBuilder();
        Integer[] arr = set.toArray(Integer[]::new);
        String sep = "";
        for (int i = 0; i < arr.length; i++) {
            System.out.print(sep + arr[i]);
//            sb.append(arr[i]);
            int j = i;
            while (j < arr.length - 1 && arr[j] + 1 == arr[j + 1]) j++;
            if (i + 1 < j) {
                i = j;
                System.out.print(" ... " + arr[i]);
//                sb.append(" ... ");
//                sb.append(arr[i]);
            }
            sep = " ";
//            sb.append(" ");
        }
//        sb.setLength(sb.length() - 1);
//        System.out.println(sb);
    }
}
