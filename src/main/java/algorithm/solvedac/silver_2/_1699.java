package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 제곱수의 합
 */
public class _1699 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] dp = new int[n + 1];
    for (int i = 1; i <= n; i++) {
      dp[i] = i;
      for (int j = 1; j * j <= i; j++) {
        dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
      }
    }
    System.out.println(dp[n]);
  }
}

/*
time complexity
O(n^1.5)

critical point
제곱수로 표현 가능한 모든 경우의 수

reference
https://www.acmicpc.net/problem/1699
*/
