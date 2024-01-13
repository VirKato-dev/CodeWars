package contest2024.task1;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        double[][] drops = {
//                {0.0, 0.0},
//                {0.1, 0.0},
//                {0.5, 0.5}
//        };
//        System.out.println(getResult(drops));

        Scanner in = new Scanner(System.in);
        double[][] drops = new double[3][2];
        for (int j = 0; j < 3; j++) {
            drops[j][0] = in.nextDouble();
            drops[j][1] = in.nextDouble();
        }
        System.out.println(getResult(drops));
    }

    public static int getResult(double[][] drops) {
        int result = 0;
        for (double[] drop : drops) {
            double distance = Math.max(drop[0], drop[1]);
            if (0.1 >= distance) {
                result += 3;
            } else if (0.8 >= distance) {
                result += 2;
            } else if (1 >= distance) {
                result++;
            }
        }
        return result;
    }
}
