package codewars.skyscapers.in4x4;

import java.util.Arrays;

public class Skyscrapers {

    /**
     * Количество зданий видимых с края карты. Обход по часовой стрелка от левого верхнего края.
     */
    private static final int[][] clues = {
            {2, 2, 1, 3, 2, 2, 3, 1, 1, 2, 2, 3, 3, 2, 1, 3},
            {0, 0, 1, 2, 0, 2, 0, 0, 0, 3, 0, 0, 0, 1, 0, 0}
    };

    /**
     * Решение для входных данных clues[]
     */
    private static final int[][][] outcomes = {
            {
                    {1, 3, 4, 2},
                    {4, 2, 1, 3},
                    {3, 4, 2, 1},
                    {2, 1, 3, 4}
            },
            {
                    {2, 1, 4, 3},
                    {3, 4, 1, 2},
                    {4, 2, 3, 1},
                    {1, 3, 2, 4}
            }
    };

    public static void main(String[] args) {
        Builds builds = new Builds(4, 4, clues[1]);
        System.out.println(Arrays.deepToString(builds.getResult()));

//        System.out.println(Arrays.deepEquals(solvePuzzle(clues[0]), outcomes[0]));
//        System.out.println(Arrays.deepEquals(solvePuzzle(clues[1]), outcomes[1]));
    }

    /**
     * Возможно только одно верное решение
     *
     * @param clues количество зданий видимых из указанной позиции
     * @return int[row][column]
     */
    static int[][] solvePuzzle(int[] clues) {
        return new int[4][4];
    }


    static class Builds {
        private final int width;
        private final int height;
        private final int[] clues;
        private final int[][] result;

        public Builds(int width, int height, int[] clues) {
            this.width = width;
            this.height = height;
            this.clues = clues;
            this.result = new int[height][width];
        }

        public int[][] getResult() {
            for (int j = 0; j < clues.length; j++) {
                int[] view = getView(j);
                placeBuilds(clues[j], view);
                setView(j, view);
            }
            return result;
        }

        /**
         * Получить направление взгляда на здания
         *
         * @param position позиция на границе карты
         * @return направление
         */
        private int[] getDirect(int position) {
            int[] direct = new int[2];
            if (position >= 2 * width + height) {
                direct[1] = 1;
            } else if (position >= width + height) {
                direct[0] = -1;
            } else if (position >= width) {
                direct[1] = -1;
            } else {
                direct[0] = 1;
            }
            return direct;
        }

        /**
         * Получить массив зданий для позиции на границе карты
         *
         * @param position позиция на границе карты
         * @return массив зданий
         */
        private int[] getView(int position) {
            int[] view;
            int[] dir = getDirect(position);
            int dY = dir[0];
            int dX = dir[1];

            if (dX == 0) {
                int col = position < width ? width -1 : width - (position - (width + height)) - 1;
                int start = dY < 0 ? height - 1 : 0;
                view = new int[height];
                for (int j = 0; j < height; j++) {
                    view[j] = result[start][col];
                    start += dY;
                }
            } else {
                int row = position < width + height ? position - width : height - (position - (2 * width + height)) - 1;
                int start = dX < 0 ? width - 1 : 0;
                view = new int[width];
                for (int j = 0; j < width; j++) {
                    view[j] = result[row][start];
                    start += dX;
                }
            }
            return view;
        }

        /**
         * Поместить массив зданий для позиции на границе карты
         *
         * @param position позиция на границе карты
         * @param view     массив зданий
         */
        private void setView(int position, int[] view) {
            int[] dir = getDirect(position);
            int dX = dir[1];
            int dY = dir[0];

            if (dX == 0) {
                int col = position % width;
                int start = dY < 0 ? height - 1 : 0;
                for (int j = 0; j < height; j++) {
                    result[start][col] = view[j];
                    start += dY;
                }
            } else {
                int row = position / width;
                int start = dX < 0 ? width - 1 : 0;
                for (int j = 0; j < width; j++) {
                    result[row][start] = view[j];
                    start += dX;
                }
            }
        }

        private void placeBuilds(int count, int[] view) {
            if (count == view.length) {
                for (int j = 0; j < view.length; j++) {
                    view[j] = j;
                }
            } else if (count == 1) {
                view[0] = view.length;
                for (int j = 1; j < view.length; j++) {
                    view[j] = view[j] == view.length ? 0 : view[j];
                }
            }
        }

    }
}
