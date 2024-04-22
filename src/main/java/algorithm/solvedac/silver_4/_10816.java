package algorithm.solvedac.silver_4;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 숫자 카드 2
 */
public class _10816 {

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative(), length = 10_000_000;
    int[] numbers = new int[length * 2 + 1];
    for (int i = 0; i < n; i++) {
      ++numbers[nextIntWithNegative() + length];
    }
    StringBuilder sb = new StringBuilder();
    int m = nextIntWithNegative();
    for (int i = 0; i < m; i++) {
      sb.append(numbers[nextIntWithNegative() + length]).append(' ');
    }
    System.out.println(sb);
  }
}

/*
time complexity
O(N + M)

critical point

reference
https://www.acmicpc.net/problem/10816
*/
