package algorithm.solvedac.silver_2;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 1, 2, 3 더하기 3
 */
public class _15988 {

  private static final FastIO io = new FastIO();

  public static void main(String[] args) throws IOException {
    int n = io.nextInt(), max = 0, mod = 1000000009;
    int[] input = new int[n];
    for (int i = 0; i < n; i++) {
      input[i] = io.nextInt();
      max = Math.max(max, input[i]);
    }

    int[] dp = new int[max + 1];
    dp[0] = 1;
    dp[1] = 1;
    dp[2] = 2;
    for (int i = 3; i <= max; i++) {
      dp[i] = ((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;
    }

    for (int i : input) {
      io.writelnInt(dp[i]);
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(n)

critical point
(dp[i - 1] + dp[i - 2] + dp[i - 3]) % mod 계산 시 overflow 발생
((dp[i - 1] + dp[i - 2]) % mod + dp[i - 3]) % mod;

reference
https://www.acmicpc.net/problem/15988
*/
