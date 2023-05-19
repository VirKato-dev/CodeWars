package codewars.sudoku.solution.validator.v3;

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
        for (int m = 0; m < 3; m++) {
            for (int i = 0; i < 9; i++) {
                int s = 0b1111111110;
                for (int j = 0; j < 9; j++) {
                    int x = m == 0 ? j % 3 + (i % 3) * 3 : (m == 1 ? i : j);
                    int y = m == 0 ? j / 3 + (i / 3) * 3 : (m == 1 ? j : i);
                    s &= ~(1 << sudoku[x][y]);
                }
                if (s != 0) return false;
            }
        }
        return true;
    }
}