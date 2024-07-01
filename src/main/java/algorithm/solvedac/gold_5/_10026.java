package algorithm.solvedac.gold_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 적록색약
 */
public class _10026 {

  private static char[][] areas;
  private static int visitedCount = 0, colorBlindVisitedCount = 0;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    areas = new char[n][n];
    for (int i = 0; i < n; i++) {
      areas[i] = br.readLine().toCharArray();
    }

    boolean[][] visited = new boolean[n][n], colorBlindVisited = new boolean[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        char current = areas[i][j];
        if (!visited[i][j]) {
          visit(current, i, j, visited, false);
          ++visitedCount;
        }
        if (!colorBlindVisited[i][j]) {
          visit(current, i, j, colorBlindVisited, true);
          ++colorBlindVisitedCount;
        }
      }
    }

    br.close();
    System.out.println(visitedCount + " " + colorBlindVisitedCount);
  }

  private static void visit(char previous, int row, int col, boolean[][] visited, boolean isColorBlind) {
    boolean isVisited = isOutOfMap(row, col, visited.length) || visited[row][col];
    if (isVisited) {
      return;
    }

    char current = areas[row][col];
    boolean colorBlind = isColorBlind && previous != 'B' && current != 'B';
    if (colorBlind || previous == current) {
      visited[row][col] = true;

      visit(current, row + 1, col, visited, isColorBlind);
      visit(current, row - 1, col, visited, isColorBlind);
      visit(current, row, col + 1, visited, isColorBlind);
      visit(current, row, col - 1, visited, isColorBlind);
    }
  }

  private static boolean isOutOfMap(int row, int col, int length) {
    return row >= length || row < 0 || col >= length || col < 0;
  }
}

/*
time complexity
O(N^2)

critical point
dfs

reference
https://www.acmicpc.net/problem/10026
*/
