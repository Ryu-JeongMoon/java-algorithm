package algorithm.solvedac.silver_5;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 수 정렬하기 2
 */
public class _2751 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt(), maxRange = 1_000_000;
    boolean[] exists = new boolean[maxRange * 2 + 2];
    for (int i = 0; i < n; i++) {
      exists[io.nextInt() + maxRange] = true;
    }

    for (int i = 0, count = 0; i < exists.length & count < n; i++) {
      if (exists[i]) {
        io.writelnInt(i - maxRange);
        ++count;
      }
    }
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
범위가 넓지 않고 개수는 많은 경우엔 정렬을 안 하는 게 제일 좋음
Arrays.sort() -> dual pivot quick sort, O(N^2) at worst case
Collections.sort() -> Tim sort, O(NlogN) at worst case

reference
https://www.acmicpc.net/problem/2751
*/
