package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 색종이
 */
public class _2563 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), result = 0;
    boolean[][] visited = new boolean[101][101];
    for (int i = 0; i < n; i++) {
      int x = nextInt(), y = nextInt();

      for (int j = x; j < x + 10; j++) {
        for (int k = y; k < y + 10; k++) {
          if (!visited[j][k]) {
            ++result;
            visited[j][k] = true;
          }
        }
      }
    }
    System.out.println(result);
  }
}

/*
time complexity
O(N)

critical point
연산 횟수 줄이기

reference
https://www.acmicpc.net/problem/2563
*/
