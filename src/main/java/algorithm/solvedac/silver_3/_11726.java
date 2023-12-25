package algorithm.solvedac.silver_3;

import static algorithm.util.SimpleIntReader.nextInt;

import java.io.IOException;

/**
 * 2×n 타일링
 */
public class _11726 {

  public static void main(String[] args) throws IOException {
    int n = nextInt();
    int[] dp = new int[n + 1];
    dp[0] = 1;
    dp[1] = 2;
    for (int i = 2; i < n; i++) {
      dp[i] = (dp[i - 2] + dp[i - 1]) % 10007;
    }
    System.out.println(dp[n - 1]);
  }
}

/*
time complexity
O(n)

critical point
이전 상태와 다음 상태가 연관 있다면 dp 고려
10007로 나눈 나머지만 필요하므로 정수 범위 넘어가지 않도록 매 연산마다 % 10007 수행

reference
https://www.acmicpc.net/problem/11726
*/
