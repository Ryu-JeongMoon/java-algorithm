 package algorithm.solvedac.bronze_1;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 수 정렬하기 3
 */
public class _10989 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int n = io.nextInt();

    int[] numbers = new int[10001];
    for (int i = 0; i < n; i++) {
      ++numbers[io.nextInt()];
    }

    for (int i = 0, count = 0; i < numbers.length & count < n; i++) {
      while (numbers[i]-- != 0) {
        io.writelnInt(i);
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
fast io

reference
https://www.acmicpc.net/problem/10989
*/
