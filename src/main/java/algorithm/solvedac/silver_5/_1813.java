package algorithm.solvedac.silver_5;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 논리학 교수
 */
public class _1813 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] numbers = new int[51];
    for (int i = 0; i < n; i++) {
      ++numbers[nextInt()];
    }

    StringBuilder sb = new StringBuilder();
    for (int i = numbers.length - 1; i >= 0; i--) {
      if (i == numbers[i]) {
        sb.append(i);
        break;
      }
    }
    System.out.println(sb.isEmpty() ? -1 : sb);
  }
}

/*
time complexity
O(N)

critical point
큰 수부터 조회

reference
https://www.acmicpc.net/problem/1813
*/
