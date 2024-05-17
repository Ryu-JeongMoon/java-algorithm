package algorithm.solvedac.silver_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 30
 */
public class _10610 {

  public static void main(String[] args) throws IOException {
    String line = new BufferedReader(new InputStreamReader(System.in)).readLine();
    int sum = 0;
    for (int i = 0; i < line.length(); i++) {
      sum += (line.charAt(i) - '0');
    }

    if (sum % 3 == 0) {
      char[] chars = line.toCharArray();
      Arrays.sort(chars);
      if (chars[0] != '0') {
        System.out.println(-1);
        return;
      }

      StringBuilder sb = new StringBuilder();
      for (int i = chars.length - 1; i >= 0; i--) {
        sb.append(chars[i]);
      }
      System.out.println(sb);
    } else {
      System.out.println(-1);
    }
  }
}

/*
time complexity
O(NlogN)

critical point
30의 배수 여부

reference
https://www.acmicpc.net/problem/10610
*/
