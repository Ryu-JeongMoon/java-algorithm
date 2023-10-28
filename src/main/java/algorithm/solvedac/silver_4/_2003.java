package algorithm.solvedac.silver_4;

import java.io.IOException;

import algorithm.util.FastIO;

/**
 * 수들의 합 2
 */
public class _2003 {

  public static void main(String[] args) throws IOException {
    FastIO io = new FastIO();
    int[] array = new int[io.nextInt()];
    long target = io.nextLong();
    for (int i = 0; i < array.length; i++) {
      array[i] = io.nextInt();
    }

    int count = 0, previousIndex = 0;
    long sum = 0;
    for (int value : array) {
      sum += value;
      while (sum > target) {
        sum -= array[previousIndex++];
      }
      if (sum == target) {
        ++count;
      }
    }
    io.writeInt(count);
    io.flushAndClose();
  }
}

/*
time complexity
O(N)

critical point
sum에 현재 값을 더한 후 target보다 크면 이전 값을 빼면서 target과 같아지거나 작아질 때까지 반복

reference
https://www.acmicpc.net/problem/2003
*/
