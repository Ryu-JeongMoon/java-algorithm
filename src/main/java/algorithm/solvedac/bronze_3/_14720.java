package algorithm.solvedac.bronze_3;

import static algorithm.util.SimpleIntReader.nextInt;

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
}

/*
time complexity
O(N)

critical point

reference
https://www.acmicpc.net/problem/14720
*/
