package algorithm.solvedac.silver_3;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 합 구하기
 */
public class _11441 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();
    int[] sum = new int[n + 1];
    for (int i = 1; i < n + 1; i++) {
      sum[i] = sum[i - 1] + io.nextInt();
    }

    int t = io.nextInt();
    for (int i = 0; i < t; i++) {
      int from = io.nextInt(), to = io.nextInt();
      io.writelnInt(sum[to] - sum[from - 1]);
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
구간 합 미리 연산

reference
https://www.acmicpc.net/problem/11441
*/
