package javarush;

import java.util.Scanner;


public class SecondMin {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n1 = in.nextInt(), n2 = in.nextInt();
        int[] res = {n1, n2 != n1 ? n2 : Integer.MAX_VALUE};
        while (in.hasNextInt()) {
            sort(res);
            n1 = in.nextInt();
            if (n1 < res[1] && n1 != res[0]) {
                res[1] = n1;
            }
        }
        sort(res);
        System.out.println(res[1]);
    }

    private static void sort(int[] n) {
        int n1 = n[0];
        int n2 = n[1];
        n[0] = Math.min(n1, n2);
        n[1] = Math.max(n1, n2);
    }
}
// 8 4 7 4 5 9 5 e
