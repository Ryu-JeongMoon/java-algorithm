package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 부분수열의 합
 */
public class _1182 {

  private static int n, s, sum, count;
  private static int[] numbers;

  public static void main(String[] args) throws IOException {
    n = nextIntWithNegative();
    s = nextIntWithNegative();
    numbers = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = nextIntWithNegative();
    }
    dfs(0);
    System.out.println(count);
  }

  private static void dfs(int step) {
    for (int i = step; i < n; i++) {
      sum += numbers[i];
      if (sum == s) {
        ++count;
      }
      dfs(i + 1);
      sum -= numbers[i];
    }
  }
}

/*
time complexity
O(2^N)

critical point
모든 경우의 수 -> dfs or bfs

reference
https://www.acmicpc.net/problem/1182
*/
