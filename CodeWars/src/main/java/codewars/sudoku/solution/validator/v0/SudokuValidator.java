package codewars.sudoku.solution.validator.v0;

import java.util.Arrays;

public class SudokuValidator {
    public static void main(String[] args) {
        int[][] m = {
                {5, 3, 4, 6, 7, 8, 9, 1, 2},
                {6, 7, 2, 1, 9, 5, 3, 4, 8},
                {1, 9, 8, 3, 4, 2, 5, 6, 7},
                {8, 5, 9, 7, 6, 1, 4, 2, 3},
                {4, 2, 6, 8, 5, 3, 7, 9, 1},
                {7, 1, 3, 9, 2, 4, 8, 5, 6},
                {9, 6, 1, 5, 3, 7, 2, 8, 4},
                {2, 8, 7, 4, 1, 9, 6, 3, 5},
                {3, 4, 5, 2, 8, 6, 1, 7, 9}
        };
        System.out.println(check(m));
    }

    public static boolean check(int[][] sudoku) {
        int[] l1 = new int[9];
        int[] l2 = new int[9];
        int[] l3 = new int[9];
        for (int i = 0; i < 81; i++) {
            l1[i % 9] = sudoku[i / 9][i % 9];
            l2[i % 9] = sudoku[i % 9][i / 9];
            l3[i % 9] = sudoku[i / 3 % 3 + i / 27 * 3][i % 3 + i / 9 * 3 % 9];
            if (i % 9 == 8) {
                System.out.println(Arrays.toString(l1));
                System.out.println(Arrays.toString(l2));
                System.out.println(Arrays.toString(l3));
                System.out.println("---");
                if (!isCorrect(l1) || !isCorrect(l2) || !isCorrect(l3)) return false;
            }
        }
        return true;
    }

    private static boolean isCorrect(int[] line) {
        return Arrays.stream(line).distinct().sum() == 45;
    }
}
