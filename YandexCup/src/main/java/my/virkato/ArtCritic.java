package my.virkato;

import java.util.Scanner;

public class ArtCritic {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] b = new int[m];
        int len = 0;
        int tmp;
        for (int j = 0; j < m; j++) {
            tmp = in.nextInt();
            if (tmp > 0) {
                if (tmp > n) tmp = n;
                b[len++] = tmp;
            }
        }

        long res = 0;
        for (int j = 0; j < len; j++) {
            res += b[j] * (long) b[j];
            for (int k = 1; k <= b[j] && j + k < len; k++) {
                res += b[j + k];
            }
        }

        System.out.println("" + res);
    }
}
