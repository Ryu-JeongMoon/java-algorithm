package algorithm.baekjoon.array;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 평균
 */
public class _1546 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());
    int max = Integer.MIN_VALUE;
    float sum = 0;

    StringTokenizer st = new StringTokenizer(br.readLine());
    for (int i = 0; i < n; i++) {
      int score = Integer.parseInt(st.nextToken());
      max = Math.max(max, score);
      sum += score;
    }

    System.out.print((sum / max * 100 / n));
  }
}
