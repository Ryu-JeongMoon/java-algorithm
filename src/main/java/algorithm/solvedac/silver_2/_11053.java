package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 가장 긴 증가하는 부분 수열
 */
public class _11053 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] array = new int[n];
    for (int i = 0; i < n; i++) {
      array[i] = nextInt();
    }

    int maxLength = 0;
    int[] dp = new int[n];
    for (int i = 1; i < n; i++) {
      for (int j = 0; j < i; j++) {
        if (array[j] < array[i]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      maxLength = Math.max(maxLength, dp[i]);
    }
    System.out.println(maxLength + 1);
  }
}

/*
time complexity
O(N^2)

critical point
정렬 X

reference
https://www.acmicpc.net/problem/11053
*/
