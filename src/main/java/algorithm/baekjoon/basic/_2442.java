package algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 별 찍기 - 5
 */
public class _2442 {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken());
    for (int i = 0; i < n; i++) {
      System.out.println(" ".repeat(n - i - 1) + "*".repeat(2 * i + 1));
    }
  }
}
