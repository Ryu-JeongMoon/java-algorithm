package algorithm.solvedac.silver_5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 다리 놓기
 */
public class _1010 {

  private static final long[] FACTORIALS = new long[]{
    1L, 1L, 2L, 6L, 24L, 120L,
    720L, 5040L, 40320L, 362880L, 3628800L,
    39916800L, 479001600L, 6227020800L, 87178291200L, 1307674368000L
  };

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int i = Integer.parseInt(br.readLine());
    while (--i >= 0) {
      String[] split = br.readLine().split(" ");
      int n = Integer.parseInt(split[0]);
      int m = Integer.parseInt(split[1]);
      sb.append(calculate(n, m)).append("\n");
    }
    System.out.println(sb);
  }

  private static long calculate(int n, int m) {
    int max = Math.max(n, m - n), min = Math.min(n, m - n);
    long numerator = 1;
    for (int i = max + 1; i <= m; i++) {
      numerator *= i;
    }
    return numerator / FACTORIALS[min];
  }
}

/*
time complexity
O(1)

critical point
1. 범위가 작아 long 배열 미리 지정
2. max+1 ~ m까지 곱하고 min!으로 나눔

reference
https://www.acmicpc.net/problem/1010
 */