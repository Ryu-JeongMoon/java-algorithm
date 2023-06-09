package algorithm.solvedac.bronze_1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 유레카 이론
 */
public class _10448 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    StringBuilder sb = new StringBuilder();
    while (--t >= 0) {
      int k = Integer.parseInt(br.readLine());
      sb.append(isEurekaNumber(k) ? 1 : 0).append("\n");
    }
    System.out.print(sb);
  }

  private static boolean isEurekaNumber(int k) {
    for (int i = 1; i < 45; i++) {
      for (int j = 1; j < 45; j++) {
        for (int l = 1; l < 45; l++) {
          int sum = (i * (i + 1) + j * (j + 1) + l * (l + 1)) / 2;
          if (sum == k) {
            return true;
          } else if (sum > k) {
            break;
          }
        }
      }
    }
    return false;
  }
}

/*
time complexity
순회 최대 범위가 고정되어 있으므로 O(n)

critical point
1. 3개의 삼각수 합이 있는 경우를 하나라도 찾아내야 하므로 early return 불가
2. k <= 1000 이므로 순회 최대 범위는 (44 + 45) / 2 = 980 -> 45까지 순회

reference
https://www.acmicpc.net/problem/10448
*/
