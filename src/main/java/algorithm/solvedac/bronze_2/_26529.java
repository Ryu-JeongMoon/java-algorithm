package algorithm.solvedac.bronze_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * Bunnies
 */
public class _26529 {

  private static final int[] MEMOIZATION = new int[46];

  public static void main(String[] args) throws IOException {
    StringBuilder sb = new StringBuilder();
    int n = nextInt();
    while (--n >= 0) {
      sb.append(fibonacci(nextInt())).append("\n");
    }
    System.out.print(sb);
  }

  private static int fibonacci(int n) {
    if (n == 0 || n == 1) {
      return 1;
    }

    if (MEMOIZATION[n] != 0) {
      return MEMOIZATION[n];
    }

    return MEMOIZATION[n] = fibonacci(n - 1) + fibonacci(n - 2);
  }
}

/*
time complexity
O(n)

critical point
1. memoization
2. simple-io

reference
https://www.acmicpc.net/problem/26529
*/
