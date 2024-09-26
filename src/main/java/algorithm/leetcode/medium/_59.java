package algorithm.leetcode.medium;

import java.util.Arrays;

/**
 * Spiral Matrix II
 */
public class _59 {

  public static void main(String[] args) {
    _59 instance = new _59();

    System.out.println(Arrays.deepToString(instance.generateMatrix(3)));
    System.out.println(Arrays.deepToString(instance.generateMatrix(1)));
  }

  public int[][] generateMatrix(int n) {
    int[][] direction = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    int[][] matrix = new int[n][n];
    boolean[][] visited = new boolean[n][n];

    int x = 0, y = 0, d = 0;
    for (int i = 0; i < n * n; i++) {
      visited[x][y] = true;
      matrix[x][y] = i + 1;

      int nextX = x + direction[d][0];
      int nextY = y + direction[d][1];
      if (isOutOfMatrix(n, nextX, nextY) || visited[nextX][nextY]) {
        d = (d + 1) % 4;
      }

      x += direction[d][0];
      y += direction[d][1];
    }

    return matrix;
  }

  private boolean isOutOfMatrix(int n, int x, int y) {
    return x < 0 || x >= n || y < 0 || y >= n;
  }
}

/*
time complexity
O(N^2)

critical point

reference
https://leetcode.com/problems/spiral-matrix-ii/
*/
