package algorithm.solvedac.silver_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 전쟁 - 전투
 */
public class _1303 {

  private static char[][] map;
  private static boolean[][] visited;
  private static int count;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] numbers = br.readLine().split(" ");
    int n = Integer.parseInt(numbers[1]), m = Integer.parseInt(numbers[0]);
    map = new char[n][m];
    for (int i = 0; i < n; i++) {
      map[i] = br.readLine().toCharArray();
    }

    int scoreOfWhite = 0, scoreOfBlue = 0;
    visited = new boolean[n][m];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        char team = map[i][j];
        count = 0;
        visit(i, j, team);
        if (team == 'W') {
          scoreOfWhite += count * count;
        } else {
          scoreOfBlue += count * count;
        }
      }
    }

    System.out.println(scoreOfWhite + " " + scoreOfBlue);
  }

  private static void visit(int i, int j, char team) {
    if (isOutOfMap(i, j) || visited[i][j] || map[i][j] != team) {
      return;
    }

    visited[i][j] = true;
    ++count;

    visit(i - 1, j, team);
    visit(i + 1, j, team);
    visit(i, j - 1, team);
    visit(i, j + 1, team);
  }

  private static boolean isOutOfMap(int i, int j) {
    return i < 0 || i > map.length - 1
      || j < 0 || j > map[0].length - 1;
  }
}

/*
time complexity
O(NM)

critical point
입력값 주의

reference
https://www.acmicpc.net/problem/1303
*/
