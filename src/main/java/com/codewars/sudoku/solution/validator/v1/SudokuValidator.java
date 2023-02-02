package com.codewars.sudoku.solution.validator.v1;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

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

    final static private Set<Integer> REF = getSetOf(IntStream.of(1, 2, 3, 4, 5, 6, 7, 8, 9));

    public static boolean check(int[][] grid) {
        return grid.length == 9
                && Stream.of(grid)
                .allMatch(a -> a.length == 9 && check(IntStream.of(a)))
                && IntStream.range(0, 9)
                .allMatch(y -> check(IntStream.range(0, 9).map(x -> grid[x][y])) && check(extractSquare(y, grid)));
    }

    private static Set<Integer> getSetOf(IntStream st) {
        return st.boxed().collect(Collectors.toSet());
    }

    private static boolean check(IntStream st) {
        return REF.equals(getSetOf(st));
    }

    private static IntStream extractSquare(int z, int[][] grid) {
        int a = z / 3 * 3, b = z % 3 * 3;
        return IntStream.range(0, 9).map(t -> grid[a + t / 3][b + t % 3]);
    }
}