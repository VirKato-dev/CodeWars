package tasks;

import java.util.Scanner;

/**
 * Получить 4 числа: k2,k3,k5,k6.
 * Они обозначают количество соответствующих цифр.
 * 1. Из представленных цифр нужно составить числа 32 или 256.
 * 2. Сумма получившихся чисел должна быть максимально возможная для текущего набора цифр.
 */
public class MaxFavouriteSum {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int k2 = in.nextInt();
        int k3 = in.nextInt();
        int k5 = in.nextInt();
        int k6 = in.nextInt();

        int n256 = available256(k2, k5, k6);
        int n32 = available32(k2, k3, n256);

        System.out.printf("%d * 32 + %d * 256 = %d%n",
                n32, n256, n32 * 32 + n256 * 256);
    }

    private static int available256(int k2, int k5, int k6) {
        return Math.min(k2, Math.min(k5, k6));
    }

    private static int available32(int k2, int k3, int n256) {
        int available = k2 - n256 - Math.min(k2, k3);
        if (available < 1) {
            return 0;
        }
        return available;
    }

}
