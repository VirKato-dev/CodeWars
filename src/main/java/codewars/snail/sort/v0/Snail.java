package codewars.snail.sort.v0;

import java.util.Arrays;

public class Snail {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(snail(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}})));
    }

    public static int[] snail(int[][] array) {
        int h = array.length; // высота матрицы
        int w = array[0].length; // ширина матрицы
        int[] res = new int[h * w]; // последовательность полученных из матрицы значений
        int x = -1, y = 0; // текущая клетка матрицы
        int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // векторы смещения по матрице
        int d = 0; // текущий вектор смещения
        int p = 0; // индекс текущего значения в результирующей последовательности

        h--;
        while (p < res.length) {
            int step = w; // максимальное количество шагов по оси будет изменяться после достижения края матрицы
            for (int rep = 0; rep < step; rep++) {
                y += dir[d][0];
                x += dir[d][1];
                res[p++] = array[y][x];
                System.out.println(Arrays.toString(res));
            }
            step--;
            d = (d + 1) % 4;
            w = h; // смена стороны
            h = step;
        }
        return res;
    }
}