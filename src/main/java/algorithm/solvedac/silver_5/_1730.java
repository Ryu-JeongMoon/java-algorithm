package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 판화
 */
public class _1730 {

  private static final int[] ROWS = { 1, 0, -1, 0 };
  private static final int[] COLS = { 0, 1, 0, -1 };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    char[][] board = new char[n][n];
    for (char[] row : board) {
      Arrays.fill(row, '.');
    }

    int x = 0, y = 0;
    String commands = br.readLine();
    for (int i = 0; i < commands.length(); i++) {
      char command = commands.charAt(i);
      int directionIndex = findDirection(command);
      int nextX = x + ROWS[directionIndex];
      int nextY = y + COLS[directionIndex];
      if (isOutOfBoard(n, nextX, nextY)) {
        continue;
      }

      char mark = command == 'D' || command == 'U' ? '|' : '-';
      markOnBoard(board, x, y, mark);
      markOnBoard(board, nextX, nextY, mark);
      x = nextX;
      y = nextY;
    }

    StringBuilder result = new StringBuilder();
    for (char[] chars : board) {
      for (char c : chars) {
        result.append(c);
      }
      result.append("\n");
    }
    System.out.print(result);
  }

  private static int findDirection(char command) {
    return switch (command) {
      case 'D' -> 0;
      case 'R' -> 1;
      case 'U' -> 2;
      case 'L' -> 3;
      default -> -1;
    };
  }

  private static boolean isOutOfBoard(int n, int nextX, int nextY) {
    return nextX < 0 || nextX >= n || nextY < 0 || nextY >= n;
  }

  private static void markOnBoard(char[][] board, int x, int y, char mark) {
    boolean crossed = board[x][y] == '+'
      || (board[x][y] == '-' && mark == '|')
      || (board[x][y] == '|' && mark == '-');

    board[x][y] = crossed ? '+' : mark;
  }
}

/*
time complexity
O(n^2)

critical point
board 출력 시 stream 사용하면 급 성능 저하
stream 236ms
for-each 72ms

reference
https://www.acmicpc.net/problem/1730
 */