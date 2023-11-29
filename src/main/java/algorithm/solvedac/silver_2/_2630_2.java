package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 색종이 만들기
 */
public class _2630_2 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[][] map = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < n; j++) {
        map[i][j] = nextInt();
      }
    }

    int[] result = divideAndConquer(map, 0, 0, n);
    System.out.println(result[0] + "\n" + result[1]);
  }

  private static int[] divideAndConquer(int[][] map, int startX, int startY, int size) {
    // result[0] for white, result[1] for blue
    int[] result = new int[2];

    int color = map[startX][startY];
    for (int i = startX; i < startX + size; i++) {
      for (int j = startY; j < startY + size; j++) {
        if (map[i][j] != color) {
          int newSize = size / 2;
          int[] upperLeft = divideAndConquer(map, startX, startY, newSize);
          int[] upperRight = divideAndConquer(map, startX, startY + newSize, newSize);
          int[] lowerLeft = divideAndConquer(map, startX + newSize, startY, newSize);
          int[] lowerRight = divideAndConquer(map, startX + newSize, startY + newSize, newSize);

          result[0] = upperLeft[0] + upperRight[0] + lowerLeft[0] + lowerRight[0];
          result[1] = upperLeft[1] + upperRight[1] + lowerLeft[1] + lowerRight[1];
          return result;
        }
      }
    }
    result[color]++;
    return result;
  }
}

/*
time complexity
O(N^2)

critical point
시간 복잡도는 같으나 배열 복사 방식 보다 효율적

reference
https://www.acmicpc.net/problem/2630
*/
