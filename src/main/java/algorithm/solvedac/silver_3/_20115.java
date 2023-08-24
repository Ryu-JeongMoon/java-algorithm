package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 에너지 드링크
 */
public class _20115 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), max = 0;
    long sum = 0;
    for (int i = 0; i < n; i++) {
      int current = nextInt();
      max = Math.max(max, current);
      sum += current;
    }
    System.out.println(max + (sum - max) / 2.0f);
  }
}

/*
time complexity
O(N)

critical point
범위 주의, 연산 횟수 줄이기

reference
https://www.acmicpc.net/problem/20115
*/
