package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 색종이 만들기
 */
public class _2630_1 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), white = 0, blue = 0, blueColor = 1;
    int[][] map = new int[n][n];
    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = nextInt();
      }
    }

    int[][] directions = new int[][] { { 0, 0 }, { 0, 1 }, { 1, 0 }, { 1, 1 } };

    Queue<int[][]> task = new LinkedList<>();
    task.add(map);
    while (!task.isEmpty()) {
      int[][] polled = task.poll();
      if (isAllSameColor(polled)) {
        if (polled[0][0] == blueColor) {
          ++blue;
        } else {
          ++white;
        }
      } else {
        int newLength = polled.length / 2;
        for (int i = 0; i < 4; i++) {
          int[][] divided = new int[newLength][newLength];
          for (int j = 0; j < newLength; j++) {
            System.arraycopy(polled[j + (newLength * directions[i][0])], (newLength * directions[i][1]), divided[j], 0, newLength);
          }
          task.add(divided);
        }
      }
    }
    System.out.println(white + "\n" + blue);
  }

  private static boolean isAllSameColor(int[][] map) {
    int initial = map[0][0];
    for (int[] row : map) {
      for (int value : row) {
        if (value != initial) {
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
배열 복사 비용

reference
https://www.acmicpc.net/problem/2630
*/
