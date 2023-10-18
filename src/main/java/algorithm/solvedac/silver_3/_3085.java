package algorithm.solvedac.silver_3;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 사탕 게임
 */
public class _3085 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();

    char[][] candies = new char[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        candies[i][j] = (char) io.read();
      }
      io.read();
    }

    int max = 0;
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n - 1; j++) {
        if (candies[i][j] != candies[i][j + 1]) {
          swap(candies, i, j, i, j + 1);
          max = Math.max(max, count(candies));
          swap(candies, i, j, i, j + 1);
        }

        if (candies[j][i] != candies[j + 1][i]) {
          swap(candies, j, i, j + 1, i);
          max = Math.max(max, count(candies));
          swap(candies, j, i, j + 1, i);
        }

        if (max == n) {
          break;
        }
      }
    }
    io.writeInt(max);
    io.flushAndClose();
  }

  private static void swap(char[][] candies, int row1, int col1, int row2, int col2) {
    char temp = candies[row1][col1];
    candies[row1][col1] = candies[row2][col2];
    candies[row2][col2] = temp;
  }

  private static int count(char[][] candies) {
    int max = 0, row = 0, col = 0;
    for (int i = 0; i < candies.length; i++) {
      row = col = 0;

      for (int j = 0; j < candies.length - 1; j++) {
        if (candies[j][i] == candies[j + 1][i]) {
          ++col;
        } else {
          max = Math.max(max, col);
          col = 0;
        }

        if (candies[i][j] == candies[i][j + 1]) {
          ++row;
        } else {
          max = Math.max(max, row);
          row = 0;
        }
      }

      max = Math.max(max, Math.max(row, col));
      if (max == candies.length - 1) {
        return max + 1;
      }
    }
    return Math.max(max, Math.max(row, col)) + 1;
  }
}

/*
time complexity
O(N^3)

critical point
문자가 다른 경우만 swap -> count, 최댓값 갱신

reference
https://www.acmicpc.net/problem/3085
*/
