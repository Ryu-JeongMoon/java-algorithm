package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import algorithm.util.FastIO;

/**
 * 수 찾기
 */
public class _1920 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();
    Set<Integer> integers = new HashSet<>(n);
    for (int i = 0; i < n; i++) {
      integers.add(io.nextInt());
    }
    int m = io.nextInt();
    for (int i = 0; i < m; i++) {
      io.writelnInt(integers.contains(io.nextInt()) ? 1 : 0);
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N + M)

critical point
음수 입력 주의

reference
https://www.acmicpc.net/problem/1920
*/
