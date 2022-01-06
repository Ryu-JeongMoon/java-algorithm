package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 별 찍기 - 7
 */
public class _2444 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());

    for (int i = 0; i < 2 * n - 1; i++) {
      int abs = Math.abs(n - i - 1);
      System.out.println(" ".repeat(abs) + "*".repeat(2 * (n - abs) - 1));
    }
  }
}
