package com.codewars.sudoku.solution.validator.v4;

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
        int[] v = {0, 0, 0};
        for (int r = 0; r < 9; r++) {
            v[0] = v[1] = v[2] = 0;
            for (int c = 0; c < 9; c++) {
                v[0] |= 1 << sudoku[r][c];
                v[1] |= 1 << sudoku[c][r];
                v[2] |= 1 << sudoku[r % 3 / 3 + c / 3][r / 3 * 3 + c % 3];
            }
            if (v[0] != 1022 || v[1] != 1022 || v[2] != 1022) return false;
        }
        return true;
    }
}