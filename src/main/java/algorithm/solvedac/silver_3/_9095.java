package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 1, 2, 3 더하기
 */
public class _9095 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), max = 0;
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = nextInt();
      max = Math.max(max, input[i]);
    }

    int[] dp = new int[11];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= max; i++) {
      dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
    }

    for (int i : input) {
      System.out.println(dp[i]);
    }
  }
}

/*
time complexity
O(n)

critical point
f(1) = 1, f(2) = 2, f(3) = 4 이므로 일반적인 풀이에서는 f(3)까지 설정해야 하는데
f(0)을 허수(1)로 두어 f(3)부터 점화식으로 풀이
f(n) = f(n-1) + f(n-2) + f(n-3)

reference
https://www.acmicpc.net/problem/9095
*/
