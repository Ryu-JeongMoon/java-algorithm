package algorithm.solvedac.silver_1;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 영역 구하기
 */
public class _2583 {

  private static boolean[][] map;
  private static boolean[][] regions;
  private static int sum = 0;

  public static void main(String[] args) throws IOException {
    int m = nextInt(), n = nextInt(), k = nextInt();
    map = new boolean[m][n];
    for (int i = 0; i < k; i++) {
      int y1 = nextInt(), x1 = Math.abs(m - nextInt()), y2 = nextInt(), x2 = Math.abs(m - nextInt());
      for (int j = x2; j < x1; j++) {
        for (int l = y1; l < y2; l++) {
          map[j][l] = true;
        }
      }
    }

    regions = new boolean[m][n];
    List<Integer> values = new ArrayList<>();
    for (int i = 0; i < m; i++) {
      for (int j = 0; j < n; j++) {
        search(i, j);
        if (sum != 0) {
          values.add(sum);
          sum = 0;
        }
      }
    }

    Collections.sort(values);
    StringBuilder sb = new StringBuilder().append(values.size()).append("\n");
    for (Integer value : values) {
      sb.append(value).append(" ");
    }
    System.out.println(sb);
  }

  private static void search(int i, int j) {
    if (isInMap(i, j) && !map[i][j] && !regions[i][j]) {
      regions[i][j] = true;
      ++sum;

      search(i, j + 1);
      search(i, j - 1);
      search(i + 1, j);
      search(i - 1, j);
    }
  }

  private static boolean isInMap(int i, int j) {
    return i < map.length && i >= 0 && j < map[0].length && j >= 0;
  }
}

/*
time complexity
O(MN)

critical point
1. 좌표 변경
2. 연결된 영역 묶기 (DFS)
3. 영역의 크기 저장 및 정렬

reference
https://www.acmicpc.net/problem/2583
*/
