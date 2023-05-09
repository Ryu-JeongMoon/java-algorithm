package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 좋은 자동차 번호판
 */
public class _1871 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    int n = Integer.parseInt(br.readLine());
    while (--n >= 0) {
      String[] s = br.readLine().split("-");
      int sum = 0;
      for (int i = 0; i < 3; i++) {
        sum += ((s[0].charAt(i) - 'A') * Math.pow(26, 2 - i));
      }
      int number = Integer.parseInt(s[1]);
      if (Math.abs(sum - number) <= 100) {
        sb.append("nice\n");
      } else {
        sb.append("not nice\n");
      }
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(N)

critical point
character integer 계산 주의

reference
https://www.acmicpc.net/problem/1871
 */
