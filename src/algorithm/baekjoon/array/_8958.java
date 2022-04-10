package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * OX퀴즈
 */
public class _8958 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int[] sum = new int[n];
    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < n; i++) {
      int score = 0;
      char[] chars = br.readLine().toCharArray();

      for (int j = 0; j < chars.length; j++) {
        if (chars[j] == 'X') {
          score = 0;
          continue;
        }
        sum[i] += ++score;
      }
      sb.append(sum[i]).append("\n");
    }

    System.out.println(sb);
  }
}
