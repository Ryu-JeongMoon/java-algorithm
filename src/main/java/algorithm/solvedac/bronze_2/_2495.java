package algorithm.solvedac.bronze_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 연속구간
 */
public class _2495 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();
    for (int n = 0; n < 3; n++) {
      int count = 0, maxCount = 0;
      String number = br.readLine();
      for (int i = 0; i < number.length() - 1; i++) {
        if (number.charAt(i) == number.charAt(i + 1)) {
          ++count;
        } else if (count != 0) {
          maxCount = Math.max(maxCount, count);
          count = 0;
        }
      }
      maxCount = count != 0 ? Math.max(maxCount, count) : maxCount;
      sb.append(maxCount + 1).append("\n");
    }
    System.out.print(sb);
  }
}

/*
time complexity
O(n)

critical point
마지막 수까지 전부 같다면 else-if 조건을 타지 않고 순회 끝나기 때문에
for 밖에서도 체크해주어야 함

reference
https://www.acmicpc.net/problem/2495
*/