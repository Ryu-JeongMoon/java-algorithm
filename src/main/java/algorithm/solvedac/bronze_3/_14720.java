package algorithm.solvedac.bronze_3;

import java.io.IOException;

/**
 * 우유 축제
 */
public class _14720 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), current = 0, count = 0;
    for (int i = 0; i < n; i++) {
      if (current == nextInt()) {
        current = (current + 1) % 3;
        ++count;
      }
    }
    System.out.println(count);
  }

  private static int nextInt() throws IOException {
    int sum = 0, input;
    while ((input = System.in.read()) >= '0') {
      sum = sum * 10 + input - '0';
    }
    return sum;
  }
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/14720
*/
