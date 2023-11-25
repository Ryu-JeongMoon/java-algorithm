package algorithm.solvedac.silver_3;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 달팽이
 */
public class _1913 {

  private static final int[][] DIRECTIONS = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt(), target = io.nextInt(), value = n * n, direction = 0, x = 0, y = 0;
    int[][] snail = new int[n][n];
    snail[0][0] = value;
    while (--value > 0) {
      int nextX = x + DIRECTIONS[direction][0], nextY = y + DIRECTIONS[direction][1];
      while (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n || snail[nextX][nextY] != 0) {
        direction = (direction + 1) % 4;
        nextX = x + DIRECTIONS[direction][0];
        nextY = y + DIRECTIONS[direction][1];
      }
      x = nextX;
      y = nextY;
      snail[x][y] = value;
    }

    x = -1;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        int current = snail[i][j];
        if (x == -1 && current == target) {
          x = i;
          y = j;
        }
        io.writeInt(current);
        io.writeBuffer((byte) ' ');
      }
      io.writeBuffer((byte) '\n');
    }
    io.writeln((x + 1) + " " + (y + 1));
    io.flushAndClose();
  }
}

/*
time complexity
O(N^2)

critical point
달팽이 이동순서를 거꾸로 생각

reference
https://www.acmicpc.net/problem/1913
*/
