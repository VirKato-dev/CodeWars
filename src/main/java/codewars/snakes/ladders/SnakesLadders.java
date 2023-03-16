package codewars.snakes.ladders;

public class SnakesLadders {
    public static void main(String[] args) {
        final int[] dice = {2, 1, 5, 1, 5, 4};
        final int[] board = {0, 0, 3, 0, 0, 0, 0, -2, 0, 0, 0};
        System.out.println(10 == Dinglemouse.snakesAndLadders(board, dice));
    }
}

class Dinglemouse {
    public static int snakesAndLadders(final int[] board, final int[] dice) {
        int pos = 0;
        int step = 0;
        while (pos < board.length && step < dice.length) {
            int move = dice[step++];
            if (pos + move < board.length) {
                pos += move;
                pos += board[pos];
            }
        }
        return pos;
    }
}
