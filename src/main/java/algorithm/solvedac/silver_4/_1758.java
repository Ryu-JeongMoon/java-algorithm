package algorithm.solvedac.silver_4;

import java.io.IOException;
import java.util.Arrays;

import algorithm.util.FastIO;

/**
 * 알바생 강호
 */
public class _1758 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int[] tips = new int[io.nextInt()];
    for (int i = 0; i < tips.length; i++) {
      tips[i] = io.nextInt();
    }
    Arrays.sort(tips);

    long sum = 0;
    for (int i = tips.length - 1, order = 1; i >= 0; i--, order++) {
      int tip = tips[i] - (order - 1);
      if (tip <= 0) {
        break;
      }
      sum += tip;
    }
    io.writeLong(sum);
    io.flushAndClose();
  }
}

/*
time complexity
O(NlogN)

critical point
결과값 범위 주의

reference
https://www.acmicpc.net/problem/1758
*/
