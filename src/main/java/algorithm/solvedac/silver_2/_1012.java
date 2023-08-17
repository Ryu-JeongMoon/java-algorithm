package algorithm.solvedac.silver_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 유기농 배추
 */
public class _1012 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    boolean[][] map;
    int[][] cabbages;

    while (--t >= 0) {
      String[] s = br.readLine().split(" ");
      int m = Integer.parseInt(s[0]);
      int n = Integer.parseInt(s[1]);
      int k = Integer.parseInt(s[2]);
      map = new boolean[n][m];
      cabbages = new int[k][2];
      for (int i = 0; i < k; i++) {
        String[] s1 = br.readLine().split(" ");
        int x = Integer.parseInt(s1[0]);
        int y = Integer.parseInt(s1[1]);
        map[y][x] = true;
        cabbages[i][0] = x;
        cabbages[i][1] = y;
      }

      int earthworm = 0;
      for (int[] cabbage : cabbages) {
        if (map[cabbage[1]][cabbage[0]]) {
          search(map, cabbage[0], cabbage[1]);
          ++earthworm;
        }
      }
      sb.append(earthworm).append("\n");
    }
    System.out.print(sb);
  }

  private static void search(boolean[][] map, int x, int y) {
    if (x < 0 || x >= map[0].length || y < 0 || y >= map.length) {
      return;
    }
    if (!map[y][x]) {
      return;
    }
    map[y][x] = false;
    search(map, x - 1, y);
    search(map, x + 1, y);
    search(map, x, y - 1);
    search(map, x, y + 1);
  }
}

/*
time complexity
n = height, m = width 일 때
O(nm)

critical point
재귀 사방 탐색

reference
https://www.acmicpc.net/problem/1012
*/
