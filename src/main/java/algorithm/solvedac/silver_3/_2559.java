package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextIntWithNegative;

import java.io.IOException;

/**
 * 수열
 */
public class _2559 {

  public static void main(String[] args) throws IOException {
    int n = nextIntWithNegative(), k = nextIntWithNegative();
    int[] temperatures = new int[n], streak = new int[n - k + 1];
    for (int i = 0; i < n; i++) {
      temperatures[i] = nextIntWithNegative();
    }
    for (int i = 0; i < k; i++) {
      streak[0] += temperatures[i];
    }
    int max = streak[0];
    for (int i = 1; i < streak.length; i++) {
      streak[i] = streak[i - 1] - temperatures[i - 1] + temperatures[i + k - 1];
      max = Math.max(max, streak[i]);
    }
    System.out.println(max);
  }
}

/*
time complexity
O(N)

critical point
연속된 부분 수열의 합
다음 합 = 이전 합 - 이전 합 중 첫번째 수 + 이전 합 중 마지막 수의 다음 수

reference
https://www.acmicpc.net/problem/2559
*/
