package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 차이를 최대로
 */
public class _10819 {

  private static int n = 0, max = 0;
  private static int[] numbers, steps;
  private static boolean[] visited;

  public static void main(String[] args) throws IOException {
    n = nextIntWithNegative();
    numbers = new int[n];
    steps = new int[n];
    for (int i = 0; i < n; i++) {
      numbers[i] = nextIntWithNegative();
    }

    visited = new boolean[n];
    dfs(0);
    System.out.println(max);
  }

  private static void dfs(int step) {
    if (step == n) {
      int sum = 0;
      for (int i = 0; i < n - 1; i++) {
        sum += Math.abs(steps[i] - steps[i + 1]);
      }
      max = Math.max(max, sum);
      return;
    }

    for (int i = 0; i < n; i++) {
      if (visited[i]) {
        continue;
      }

      visited[i] = true;
      steps[step] = numbers[i];
      dfs(step + 1);
      visited[i] = false;
    }
  }
}

/*
time complexity
O(N!)

critical point
dfs의 이해

reference
https://www.acmicpc.net/problem/10819
*/
