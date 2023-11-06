package algorithm.solvedac.silver_1;

import java.io.IOException;
import java.util.Arrays;

import algorithm.util.FastIO;

/**
 * 단지번호붙이기
 */
public class _2667 {

  private static final int byte1 = 49;
  private static int[] COUNTS;
  private static int[][] MAP;
  private static final int[][] DIRECTIONS = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();
    MAP = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        MAP[i][j] = io.read();
      }
      io.read();
    }

    int sequence = 0;
    COUNTS = new int[MAP.length * MAP.length];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        if (MAP[i][j] == byte1) {
          mark(i, j, sequence++);
        }
      }
    }

    Arrays.sort(COUNTS, 0, sequence);
    io.writelnInt(sequence);
    for (int i = 0; i < sequence; i++) {
      io.writelnInt(COUNTS[i]);
    }
    io.flushAndClose();
  }

  private static void mark(int i, int j, int sequence) {
    MAP[i][j] = sequence;
    ++COUNTS[sequence];

    for (int k = 0; k < DIRECTIONS.length; k++) {
      int row = i + DIRECTIONS[k][0];
      int col = j + DIRECTIONS[k][1];
      if (!isOutOfMap(i, j, k) && MAP[row][col] == byte1) {
        mark(row, col, sequence);
      }
    }
  }

  private static boolean isOutOfMap(int i, int j, int k) {
    return i + DIRECTIONS[k][0] < 0
      || i + DIRECTIONS[k][0] >= MAP.length
      || j + DIRECTIONS[k][1] < 0
      || j + DIRECTIONS[k][1] >= MAP.length;
  }
}

/*
time complexity
O(N^2)

critical point
전방향 탐색 DFS

reference
https://www.acmicpc.net/problem/2667
*/
