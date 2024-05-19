package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 모두의 마블
 */
public class _12845 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), max = 0, sum = 0;
    int[] levels = new int[n];
    for (int i = 0; i < n; i++) {
      levels[i] = nextInt();
      if (max < levels[i]) {
        max = levels[i];
      }
      sum += levels[i];
    }
    int remains = n > 2 ? max * (n - 2) : 0;
    System.out.println(sum + remains);
  }
}

/*
time complexity
O(N)

critical point
1. 가장 큰 수 찾기
2. 가장 큰 수 제외, 다른 수와 개별 합 누적

reference
https://www.acmicpc.net/problem/12845
*/
