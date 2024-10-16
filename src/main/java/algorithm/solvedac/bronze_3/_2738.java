package algorithm.solvedac.bronze_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 행렬 덧셈
 */
public class _2738 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt();
    int[][] array = new int[n][m];
    for (int i = 0; i < 2; i++) {
      for (int j = 0; j < n; j++) {
        for (int k = 0; k < m; k++) {
          array[j][k] += nextInt();
        }
      }
    }

    StringBuilder sb = new StringBuilder();
    for (int[] ints : array) {
      for (int anInt : ints) {
        sb.append(anInt).append(' ');
      }
      sb.append('\n');
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(NM)

critical point

reference
https://www.acmicpc.net/problem/2738
*/
