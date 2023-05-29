package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 달팽이2
 */
public class _1952 {

  private static final int[] ROWS = { 0, 1, 0, -1 };
  private static final int[] COLS = { 1, 0, -1, 0 };

  public static void main(String[] args) throws IOException {
    String[] s = new BufferedReader(new InputStreamReader(System.in)).readLine().split(" ");
    int m = Integer.parseInt(s[0]), n = Integer.parseInt(s[1]);

    simple(m, n);
    complex(m, n);
  }

  private static void simple(int m, int n) {
    System.out.println(m > n ? n * 2 - 1 : (m - 1) * 2);
  }

  private static void complex(int m, int n) {
    boolean[][] snail = new boolean[m][n];
    int visitCount = 0, count = 0, direction = 0, row = 0, col = 0;
    while (visitCount < m * n - 1) {
      if (!snail[row][col]) {
        snail[row][col] = true;
        ++visitCount;
      }

      int newRow = row + ROWS[direction];
      int newCol = col + COLS[direction];
      if (isOutOfMapOrVisited(snail, newRow, newCol)) {
        direction = (direction + 1) % 4;
        ++count;
        newRow = row + ROWS[direction];
        newCol = col + COLS[direction];
      }

      row = newRow;
      col = newCol;
    }
    System.out.println(count);
  }

  private static boolean isOutOfMapOrVisited(boolean[][] snail, int row, int col) {
    return (row < 0 || row >= snail.length)
      || (col < 0 || col >= snail[0].length)
      || snail[row][col];
  }
}

/*
time complexity
O(1)  - simple
O(mn) - complex

critical point
m*n-1 까지만 순회하여 마지막 방문에서 count 증가시키지 못하도록 해야 함

reference
https://www.acmicpc.net/problem/1952
 */