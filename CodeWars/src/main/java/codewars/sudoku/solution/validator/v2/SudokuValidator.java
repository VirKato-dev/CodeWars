package codewars.sudoku.solution.validator.v2;

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

    public static boolean check(int[][] sud) {
        for (int i = 0; i < 9; i++) {
            int col = 0, row = 0, block = 0;
            for (int j = 0; j < 9; j++) {
                col += Math.pow(2, sud[i][j]);
                row += Math.pow(2, sud[j][i]);
                block += Math.pow(2, sud[3 * i % 3 + j % 3][j / 3]);
            }
            if (col != 1022 || row != 1022 || block != 1022) return false;
        }
        return true;
    }
}