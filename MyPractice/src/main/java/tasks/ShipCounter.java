package tasks;

public class ShipCounter {

    public static void main(String[] args) {
        int[][] battleField = new int[][]{
                {1, 1, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0},
                {1, 0, 1, 0, 1, 0},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 0}
        };
        System.out.println(countShips(battleField)); // 6
    }


    public static int countShips(int[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {        // по строкам
            for (int j = 0; j < board[0].length; j++) { // по колонкам

                if (board[i][j] == 1) {
                    if ((i > 0 && board[i - 1][j] == 1)
                            || (j > 0 && board[i][j - 1] == 1)) {
                        continue;
                    }
                    count++;    // только если встретили начало корабля
                    // а не его середину/хвост по горизонтали или вертикали
                }

            }
        }
        return count;
    }
}
