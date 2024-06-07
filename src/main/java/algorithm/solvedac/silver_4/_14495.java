package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 피보나치 비스무리한 수열
 */
public class _14495 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    System.out.println(n < 4 ? 1 : findLast(n));
  }

  private static long findLast(int n) {
    long[] array = new long[117];
    array[1] = array[2] = array[3] = 1;
    for (int i = 4; i < n + 1; i++) {
      array[i] = array[i - 1] + array[i - 3];
    }
    return array[n];
  }
}

/*
time complexity
O(N)

critical point
범위 주의

reference
https://www.acmicpc.net/problem/14495
*/
