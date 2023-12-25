package algorithm.solvedac.silver_2;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 상자넣기
 */
public class _1965 {

  public static void main(String[] args) throws IOException {
    int n = nextInt(), max = 0;
    int[] boxes = new int[n], dp = new int[n];
    for (int i = 0; i < n; i++) {
      boxes[i] = nextInt();
      for (int j = 0; j < i; j++) {
        if (boxes[i] > boxes[j]) {
          dp[i] = Math.max(dp[i], dp[j] + 1);
        }
      }
      max = Math.max(max, dp[i]);
    }
    System.out.println(max + 1);
  }
}

/*
time complexity
O(n^2)

critical point
LIS, longest increasing subsequence

reference
https://www.acmicpc.net/problem/1965
*/
