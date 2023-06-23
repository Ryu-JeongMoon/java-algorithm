package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 피보나치 수 2
 */
public class _2748 {

  private static final ConcurrentHashMap<Long, Long> MEMOIZATION = new ConcurrentHashMap<>();

  public static void main(String[] args) throws IOException {
    String input = new BufferedReader(new InputStreamReader(System.in)).readLine();

    System.out.println(fibonacciByMap(Long.parseLong(input)));
    System.out.println(fibonacciByArray(Integer.parseInt(input)));
  }

  private static long fibonacciByMap(long n) {
    if (n == 0 || n == 1) {
      return n;
    } else if (MEMOIZATION.get(n) != null) {
      return MEMOIZATION.get(n);
    }

    long result = fibonacciByMap(n - 1) + fibonacciByMap(n - 2);
    MEMOIZATION.putIfAbsent(n, result);
    return result;
  }

  private static long fibonacciByArray(int n) {
    long[] dp = new long[n + 1];
    dp[0] = 0;
    dp[1] = 1;
    for (int i = 2; i < n + 1; i++) {
      dp[i] = dp[i - 1] + dp[i - 2];
    }
    return dp[n];
  }
}

/*
time complexity
O(n)

critical point

reference
https://www.acmicpc.net/problem/2475
*/
