package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 종이의 개수
 */
public class _1780 {

  private static final int[] count = new int[3];
  private static int[][] map;

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative();
    map = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = nextIntWithNegative();
      }
    }
    count(0, 0, n);
    for (int c : count) {
      System.out.println(c);
    }
  }

  private static void count(int startX, int startY, int length) {
    if (isAllSameColor(startX, startY, length)) {
      ++count[map[startX][startY] + 1];
      return;
    }

    length /= 3;
    for (int i = 0; i < 3; i++) {
      for (int j = 0; j < 3; j++) {
        count(startX + i * length, startY + j * length, length);
      }
    }
  }

  private static boolean isAllSameColor(int startX, int startY, int length) {
    int color = map[startX][startY];
    for (int i = startX; i < startX + length; i++) {
      for (int j = startY; j < startY + length; j++) {
        if (color != map[i][j]) {
          return false;
        }
      }
    }
    return true;
  }
}

/*
time complexity
O(N^2)

critical point
색종이 만들기와 유사

reference
https://www.acmicpc.net/problem/1780
*/
