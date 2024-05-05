package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 2차원 배열의 합
 */
public class _2167 {

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative(), m = nextIntWithNegative();
    int[][] array = new int[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        array[i][j] = nextIntWithNegative();
      }
    }

    int t = nextIntWithNegative();
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < t; i++) {
      int sum = 0, startX = nextIntWithNegative() - 1, startY = nextIntWithNegative() - 1, endX = nextIntWithNegative() - 1, endY = nextIntWithNegative() - 1;
      for (int j = startX; j <= endX; j++) {
        for (int k = startY; k <= endY; k++) {
          sum += array[j][k];
        }
      }
      sb.append(sum).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(NM + T * (X * Y))

critical point
prefix sum ?!

reference
https://www.acmicpc.net/problem/2167
*/
