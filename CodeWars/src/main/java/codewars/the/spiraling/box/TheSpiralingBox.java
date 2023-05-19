package codewars.the.spiraling.box;

import java.util.Arrays;

public class TheSpiralingBox {
    public static void main(String[] args) {
        Arrays.stream(SpiralingBox.createBox(7, 5)).forEach(m -> System.out.println(Arrays.toString(m)));
    }
}

class SpiralingBox {
    public static int[][] createBox(int w, int h) {
        int[][] m = new int[h][w];
        for (int j = 0; j < h; j++) {
            for (int k = 0; k < w; k++) {
                int line = j < h / 2 ? j + 1 : h - j;
                int col = k < w / 2 ? k + 1 : w - k;
                m[j][k] = col > line ? line : col;
//                m[j][k] = (j < h / 2 ? j + 1 : h - j) + (k < w / 2 ? k : w - k - 1); // ромбы
            }
        }
        return m;
    }
}