package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import algorithm.util.FastIO;

/**
 * CD
 */
public class _4158 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt(), m = io.nextInt();
    while (n != 0 && m != 0) {
      int count = 0;
      Set<Integer> elements = new HashSet<>(Math.max(n, m));
      for (int i = 0; i < n + m; i++) {
        int value = io.nextInt();
        if (elements.contains(value)) {
          ++count;
        } else {
          elements.add(value);
        }
      }
      io.writelnInt(count);

      n = io.nextInt();
      m = io.nextInt();
    }
    io.flushBuffer();
  }
}

/*
time complexity

critical point
입력은 여러 개의 테스트 케이스!!

reference
https://www.acmicpc.net/problem/4158
*/
