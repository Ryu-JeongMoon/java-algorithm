package algorithm.solvedac.silver_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 음식물 피하기
 */
public class _1743 {

  private static boolean[][] corridor, visited;

  public static void main(String[] args) throws IOException {
    int n = nextInt(), m = nextInt(), k = nextInt(), max = 0;
    corridor = new boolean[n][m];
    visited = new boolean[n][m];
    for (int i = 0; i < k; i++) {
      corridor[nextInt() - 1][nextInt() - 1] = true;
    }
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        if (corridor[i][j]) {
          max = Math.max(max, visit(i, j));
        }
      }
    }
    System.out.println(max);
  }

  private static int visit(int row, int col) {
    boolean outOfRange = row >= corridor.length || row < 0 || col >= corridor[0].length || col < 0;
    if (outOfRange || !corridor[row][col] || visited[row][col]) {
      return 0;
    }

    visited[row][col] = true;
    return 1
      + visit(row, col - 1)
      + visit(row, col + 1)
      + visit(row + 1, col)
      + visit(row - 1, col);
  }
}

/*
time complexity
O(NM)

critical point
1. 시작 부분을 중심으로 잡고 사방으로 뻗어나가며 음식물인 경우 count 증가
2. 시작 부분은 음식물이므로 count 1부터 시작

reference
https://www.acmicpc.net/problem/1743
*/
