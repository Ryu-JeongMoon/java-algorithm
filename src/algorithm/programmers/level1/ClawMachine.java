package algorithm.programmers.level1;

import java.util.LinkedList;

public class ClawMachine {
    public static void main(String[] args) {
        int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } };
        int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
        System.out.println(solution(board, moves));
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;
        LinkedList<Integer> bucket = new LinkedList<>();

        int lastNumber = -1;
        int newlyAddedNumber = -1;


        for (int move : moves) {
            for (int i = 0; i < board.length; i++) {

                if (!bucket.isEmpty())
                    lastNumber = bucket.getLast();

                if (board[i][move - 1] != 0) {
                    bucket.add(board[i][move - 1]);
                    board[i][move - 1] = 0;
                    newlyAddedNumber = bucket.getLast();

                    if (lastNumber == newlyAddedNumber) {
                        bucket.removeLast();
                        bucket.removeLast();
                        answer += 2;
                    }

                    break;
                }
            }

        }


        return answer;
    }
}

/**
 * 우헤헤
 */